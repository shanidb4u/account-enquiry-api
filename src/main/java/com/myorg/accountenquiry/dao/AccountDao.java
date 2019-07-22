package com.myorg.accountenquiry.dao;

import com.myorg.accountenquiry.domain.Account;

import java.util.List;

public interface AccountDao {
    List<Account> getAccounts(String userId);
}
