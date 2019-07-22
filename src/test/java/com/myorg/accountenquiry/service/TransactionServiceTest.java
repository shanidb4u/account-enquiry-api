package com.myorg.accountenquiry.service;

import com.myorg.accountenquiry.dao.TransactionDao;
import com.myorg.accountenquiry.domain.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TransactionServiceTest {

    TransactionService testInstance;

    @Mock
    TransactionDao transactionDao;

    @Before
    public void setUp() throws Exception {
        testInstance = new TransactionService(transactionDao);
    }

    @Test
    public void getTransactions() {
        when(transactionDao.getTransactions("1234"))
                .thenReturn(getTransactionData());
        List<Transaction> result = testInstance.getTransactions("1234");
        assertEquals(1, result.size());
        assertEquals(345345, result.get(0).getTransactionId().longValue());

    }

    private List<Transaction> getTransactionData() {
        return asList(Transaction.builder().transactionId(345345L).build());
    }
}