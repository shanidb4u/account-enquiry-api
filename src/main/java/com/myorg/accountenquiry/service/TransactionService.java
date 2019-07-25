package com.myorg.accountenquiry.service;

import com.myorg.accountenquiry.domain.Transaction;

import java.util.List;

public interface TransactionService {

    List<Transaction> getTransactions(String accountNumber);

}
