package com.myorg.accountenquiry.dao.impl;

import com.myorg.accountenquiry.converter.TransactionConverter;
import com.myorg.accountenquiry.dao.TransactionDao;
import com.myorg.accountenquiry.dao.repo.TransactionRepository;
import com.myorg.accountenquiry.domain.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransactionDaoImpl implements TransactionDao {

    TransactionRepository transactionRepository;

    public TransactionDaoImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<Transaction> getTransactions(String accountNumber) {
        return TransactionConverter.toTransactions(transactionRepository.findByAccount_AccountNumber(accountNumber));
    }
}
