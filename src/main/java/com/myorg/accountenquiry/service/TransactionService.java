package com.myorg.accountenquiry.service;

import com.myorg.accountenquiry.dao.TransactionDao;
import com.myorg.accountenquiry.domain.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    TransactionDao transactionDao;

    @Autowired
    public TransactionService(TransactionDao transactionDao) {
        this.transactionDao = transactionDao;
    }

    public List<Transaction> getTransactions(String accountNumber) {
        return transactionDao.getTransactions(accountNumber);
    }

}
