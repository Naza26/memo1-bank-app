package com.aninfo.service;

import com.aninfo.model.Transaction;
import com.aninfo.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public Collection<Transaction> getTransactions() {
        return transactionRepository.findAll();
    }

    public Optional<Transaction> findById(Long cbu) {
        return transactionRepository.findById(cbu);
    }

    public Collection<Transaction> findAllTransactionsByAccountId(Long cbu) {
        Collection<Transaction> allTransactions = this.getTransactions();
        Collection<Transaction> allTransactionsByGivenId = new ArrayList<>();
        for (Transaction transaction : allTransactions) {
           if (transaction.getCbu() == cbu) {
               allTransactionsByGivenId.add(transaction);
            }
        }
        return allTransactionsByGivenId;
    }

    public void deleteById(Long cbu) {
        transactionRepository.deleteById(cbu);
    }
}
