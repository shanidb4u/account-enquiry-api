package com.myorg.accountenquiry.dao.impl;

import com.myorg.accountenquiry.dao.repo.AccountRepository;
import com.myorg.accountenquiry.domain.Account;
import com.myorg.accountenquiry.domain.entity.AccountEntity;
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
public class AccountDaoImplTest {

    AccountDaoImpl testInstance;

    @Mock
    AccountRepository accountRepository;


    @Before
    public void setUp() throws Exception {
        testInstance = new AccountDaoImpl(accountRepository);
    }

    @Test
    public void getAccounts() {
        when(accountRepository.findByUserId("user1")).thenReturn(getAccountEntities());
        List<Account> result = testInstance.getAccounts("user1");
        assertEquals(1, result.size());
        assertEquals(100123L, result.get(0).getAccountId().longValue());
    }

    private List<AccountEntity> getAccountEntities() {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setAccountId(100123L);
        return Arrays.asList(accountEntity);
    }
}