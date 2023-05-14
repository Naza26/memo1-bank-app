package com.aninfo.model;

import javax.persistence.*;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;
    private Long cbu;
    private TransactionType type;
    private Double amount;

    public Transaction() {}

    public Transaction(Long cbu, TransactionType type, Double amount) {
        this.cbu = cbu;
        this.type = type;
        this.amount = amount;
    }

    public Long getTransactionId() {return transactionId;}

    public Long getCbu() {
        return cbu;
    }

    public void setCbu(Long cbu) {
        this.cbu = cbu;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount( Double amount) {
        this.amount = amount;
    }

    public TransactionType getTypeOfTransaction() {
        return type;
    }

    public void setTransactionType( TransactionType type) {
        this.type = type;
    }

    public enum TransactionType {
        DEPOSIT,
        WITHDRAW
    }
}
