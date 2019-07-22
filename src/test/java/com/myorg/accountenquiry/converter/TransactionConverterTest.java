package com.myorg.accountenquiry.converter;

import com.myorg.accountenquiry.domain.Transaction;
import com.myorg.accountenquiry.domain.entity.AccountEntity;
import com.myorg.accountenquiry.domain.entity.TransactionEntity;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class TransactionConverterTest {

    @Test
    public void toTransactions() {
        List<Transaction> transactions = TransactionConverter.toTransactions(getTransactionEntities());
        assertEquals(1, transactions.size());
        Transaction transaction = transactions.get(0);
        assertEquals(676767L, transaction.getTransactionId().longValue());
        assertEquals("234-456", transaction.getAccountNumber());
        assertEquals("Account 1", transaction.getAccountName());
        assertEquals(12000.75, transaction.getAmount().doubleValue(), 0.001);
        assertEquals("AUD", transaction.getCurrency());
        assertEquals("D", transaction.getTransactionType());
        assertEquals("2019-12-31", transaction.getValueDate().toString());
        assertEquals("Transaction 1", transaction.getTransactionNarrative());
    }

    private List<TransactionEntity> getTransactionEntities() {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setAccountNumber("234-456");
        accountEntity.setAccountName("Account 1");

        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setTransactionId(676767L);
        transactionEntity.setAccount(accountEntity);
        transactionEntity.setAmount(12000.75D);
        transactionEntity.setCurrency("AUD");
        transactionEntity.setValueDate(LocalDate.of(2019,12,31));
        transactionEntity.setTransactionType("D");
        transactionEntity.setTransactionNarrative("Transaction 1");

        return asList(transactionEntity);
    }
}