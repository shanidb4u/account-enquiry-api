package com.myorg.accountenquiry.service.impl;

import com.myorg.accountenquiry.converter.TransactionConverter;
import com.myorg.accountenquiry.repo.TransactionRepository;
import com.myorg.accountenquiry.domain.Transaction;
import com.myorg.accountenquiry.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    TransactionRepository transactionRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<Transaction> getTransactions(String accountNumber) {
        return TransactionConverter.toTransactions(transactionRepository.findByAccount_AccountNumber(accountNumber));
    }
}
