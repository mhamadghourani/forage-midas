package com.jpmc.midascore.entity;

import jakarta.persistence.*;
// 1. REMOVE the catalina import
// 2. ADD your own entity import:
import com.jpmc.midascore.entity.UserRecord;

@Entity
public class TransactionRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private float amount;

    // 3. CHANGE the type to UserRecord
    @ManyToOne
    @JoinColumn(name = "sender_id")
    private UserRecord sender;

    @ManyToOne
    @JoinColumn(name = "recipient_id")
    private UserRecord recipient;

    private float incentive;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public float getAmount() { return amount; }
    public void setAmount(float amount) { this.amount = amount; }

    public UserRecord getSender() { return sender; }
    public void setSender(UserRecord sender) { this.sender = sender; }
    public UserRecord getRecipient() { return recipient; }
    public void setRecipient(UserRecord recipient) { this.recipient = recipient; }

    public float getIncentive() {
        return incentive;
    }

    public void setIncentive(float incentive) {
        this.incentive = incentive;
    }
}