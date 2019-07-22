package com.myorg.accountenquiry.converter;

import com.myorg.accountenquiry.domain.Account;
import com.myorg.accountenquiry.domain.entity.AccountEntity;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AccountConverterTest {

    @Test
    public void toAccounts() {
        List<Account> accounts = AccountConverter.toAccounts(getAccountEntities());
        assertEquals(1, accounts.size());
        Account account = accounts.get(0);
        assertEquals(100123L, account.getAccountId().longValue());
        assertEquals("234-456", account.getAccountNumber());
        assertEquals("Acc1", account.getAccountName());
        assertEquals("Debit", account.getAccountType());
        assertEquals("2019-12-31", account.getBalanceDate().toString());
        assertEquals("AUD", account.getCurrency());
        assertEquals(3000, account.getOpeningBalance().doubleValue(), 0.001);
    }

    private List<AccountEntity> getAccountEntities() {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setAccountId(100123L);
        accountEntity.setAccountNumber("234-456");
        accountEntity.setAccountName("Acc1");
        accountEntity.setAccountType("Debit");
        accountEntity.setBalanceDate(LocalDate.of(2019,12,31));
        accountEntity.setCurrency("AUD");
        accountEntity.setOpeningBalance(3000D);
        return Arrays.asList(accountEntity);
    }
}