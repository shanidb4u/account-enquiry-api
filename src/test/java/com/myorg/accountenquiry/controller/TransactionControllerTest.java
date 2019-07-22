package com.myorg.accountenquiry.controller;

import com.myorg.accountenquiry.domain.Transaction;
import com.myorg.accountenquiry.service.TransactionService;
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
public class TransactionControllerTest {

    @Mock
    TransactionService transactionService;

    TransactionController testInstance;


    @Before
    public void setUp() throws Exception {
        testInstance = new TransactionController(transactionService);
    }

    @Test
    public void getTransactions() {
        when(transactionService.getTransactions("1234"))
                .thenReturn(getTransactionData());
        List<Transaction> result = testInstance.getTransactions("1234");
        assertEquals(1, result.size());
        assertEquals(345345, result.get(0).getTransactionId().longValue());

    }

    @Test(expected = IllegalArgumentException.class)
    public void getTransactions_AccountNumberEmpty() {
        testInstance.getTransactions("");
    }

    private List<Transaction> getTransactionData() {
        return asList(Transaction.builder().transactionId(345345L).build());
    }

}