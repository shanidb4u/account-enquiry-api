package com.myorg.accountenquiry.converter;

import com.myorg.accountenquiry.domain.Transaction;
import com.myorg.accountenquiry.domain.entity.TransactionEntity;

import java.util.List;
import java.util.stream.Collectors;

public class TransactionConverter {
    private TransactionConverter() {
    }

    public static List<Transaction> toTransactions(List<TransactionEntity> transactionEntities) {
        return transactionEntities.stream()
                .map(TransactionConverter::mapTransactionEntityToTransaction)
                .collect(Collectors.toList());
    }

    private static Transaction mapTransactionEntityToTransaction(TransactionEntity transactionEntity) {
        return Transaction.builder()
                .transactionId(transactionEntity.getTransactionId())
                .accountName(transactionEntity.getAccount().getAccountName())
                .accountNumber(transactionEntity.getAccount().getAccountNumber())
                .amount(transactionEntity.getAmount())
                .currency(transactionEntity.getCurrency())
                .transactionType(transactionEntity.getTransactionType())
                .valueDate(transactionEntity.getValueDate())
                .transactionNarrative(transactionEntity.getTransactionNarrative())
                .build();
    }

}
