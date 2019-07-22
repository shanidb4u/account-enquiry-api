package com.myorg.accountenquiry.controller;


import com.myorg.accountenquiry.domain.Account;
import com.myorg.accountenquiry.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AccountControllerTest {

    @Mock
    AccountService accountService;

    AccountController testInstance;

    @Before
    public void setUp() {
        testInstance = new AccountController(accountService);
    }


    @Test
    public void testGetAccounts() {
        when(accountService.getAccounts("user1")).thenReturn(getAccountsData());
        List<Account> result = testInstance.getAccounts("user1");
        assertEquals(1, result.size());
        assertEquals(789789L, result.get(0).getAccountId().longValue());
    }

    private List<Account> getAccountsData() {
        return Arrays.asList(Account.builder().accountId(789789L).build());
    }


}