package com.myorg.accountenquiry.dao;

import com.myorg.accountenquiry.dao.repo.AccountRepository;
import com.myorg.accountenquiry.domain.entity.AccountEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountRepositoryIntegrationTest {

    @Autowired
    AccountRepository accountController;

    @Test
    public void getAccounts() {
        List<AccountEntity> accounts = accountController.findByUserId("anzuser");

        Assert.assertEquals(2, accounts.size());

        AccountEntity acc1 = accounts.get(0);

        Assert.assertEquals(1001, acc1.getAccountId().longValue());
        Assert.assertEquals("anzuser", acc1.getUserId());
        Assert.assertEquals("ausavings123", acc1.getAccountName());
        Assert.assertEquals("123123345", acc1.getAccountNumber());
        Assert.assertEquals("Savings", acc1.getAccountType());
        Assert.assertEquals("AUD", acc1.getCurrency());
        Assert.assertEquals("2019-01-01", acc1.getBalanceDate().toString());
        Assert.assertEquals(1234.75, acc1.getOpeningBalance().doubleValue(), 0.001);
    }

}
