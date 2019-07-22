package com.myorg.accountenquiry.service;

import com.myorg.accountenquiry.dao.AccountDao;
import com.myorg.accountenquiry.domain.Account;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceTest {

    AccountService testInstance;

    @Mock
    AccountDao accountDao;


    @Before
    public void setUp() throws Exception {
        testInstance = new AccountService(accountDao);
    }

    @Test
    public void getAccounts() {
        when(accountDao.getAccounts("user1")).thenReturn(getAccountsData());
        List<Account> result = testInstance.getAccounts("user1");
        assertEquals(1, result.size());
        assertEquals(789789L, result.get(0).getAccountId().longValue());
    }

    private List<Account> getAccountsData() {
        return Arrays.asList(Account.builder().accountId(789789L).build());
    }
}