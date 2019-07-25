package com.myorg.accountenquiry.service.impl;

import com.myorg.accountenquiry.domain.Transaction;
import com.myorg.accountenquiry.domain.entity.AccountEntity;
import com.myorg.accountenquiry.domain.entity.TransactionEntity;
import com.myorg.accountenquiry.repo.TransactionRepository;
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
public class TransactionServiceImplTest {

    TransactionService testInstance;

    @Mock
    TransactionRepository repository;

    @Before
    public void setUp() {
        testInstance = new TransactionServiceImpl(repository);
    }

    @Test
    public void getTransactions() {
        when(repository.findByAccount_AccountNumber("1234"))
                .thenReturn(getTransactionEntities());
        List<Transaction> result = testInstance.getTransactions("1234");
        assertEquals(1, result.size());
        assertEquals(676767L, result.get(0).getTransactionId().longValue());

    }

    private List<TransactionEntity> getTransactionEntities() {
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setTransactionId(676767L);
        transactionEntity.setAccount(new AccountEntity());
        return asList(transactionEntity);
    }
}