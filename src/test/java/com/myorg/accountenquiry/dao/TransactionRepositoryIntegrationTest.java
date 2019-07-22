package com.myorg.accountenquiry.dao;

import com.myorg.accountenquiry.dao.repo.TransactionRepository;
import com.myorg.accountenquiry.domain.entity.TransactionEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionRepositoryIntegrationTest {

    @Autowired
    TransactionRepository transactionRepository;

    @Test
    public void getAccounts() {
        List<TransactionEntity> transactionEntities = transactionRepository.findByAccount_AccountNumber("123123345");
        assertEquals(2, transactionEntities.size());
        TransactionEntity transactionEntity = transactionEntities.get(0);
        assertEquals(5001, transactionEntity.getTransactionId().longValue());
        assertEquals("AUD", transactionEntity.getCurrency());
        assertEquals(1000, transactionEntity.getAmount().doubleValue(), .001);
        assertEquals("Debit", transactionEntity.getTransactionType());
        assertEquals("Transfer 1", transactionEntity.getTransactionNarrative());
    }

}
