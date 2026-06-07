package com.jpmc.midascore.services;

import com.jpmc.midascore.entity.TransactionRecord;
import com.jpmc.midascore.entity.UserRecord; // Use your entity!
import com.jpmc.midascore.foundation.Balance;
import com.jpmc.midascore.foundation.Transaction;
import com.jpmc.midascore.repository.TransactionRepository;
import com.jpmc.midascore.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TransactionListener {

    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;
    private final RestTemplate restTemplate;

    public TransactionListener(TransactionRepository transactionRepository, UserRepository userRepository, RestTemplate restTemplate) {
        this.transactionRepository = transactionRepository;
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
    }

    @Transactional
    @KafkaListener(topics = "${general.kafka-topic}", groupId = "midas-core-group")
    public void listen(Transaction transaction) {

        UserRecord sender = userRepository.findById(transaction.getSenderId());
        UserRecord recipient = userRepository.findById(transaction.getRecipientId());

        if (sender != null && recipient != null && sender.getBalance() >= transaction.getAmount()) {

            String url = "http://localhost:8080/incentive";

            Balance response = restTemplate.postForObject(url, transaction, Balance.class);
            float incentive = (response != null) ? response.getAmount() : 0.0f;

            sender.setBalance(sender.getBalance() - transaction.getAmount());
            recipient.setBalance(recipient.getBalance() + transaction.getAmount() + incentive);

            userRepository.save(sender);
            userRepository.save(recipient);

            // PRINT BALANCES HERE
            System.out.println(
                    sender.getName() + " -> " + sender.getBalance());

            System.out.println(
                    recipient.getName() + " -> " + recipient.getBalance());

            TransactionRecord record = new TransactionRecord();
            record.setSender(sender);
            record.setRecipient(recipient);
            record.setAmount(transaction.getAmount());

            record.setIncentive(incentive);

            transactionRepository.save(record);
        }
    }
}