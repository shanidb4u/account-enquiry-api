package com.myorg.accountenquiry.dao;

import com.myorg.accountenquiry.domain.Transaction;

import java.util.List;

public interface TransactionDao {
    List<Transaction> getTransactions(String accountNumber);
}
