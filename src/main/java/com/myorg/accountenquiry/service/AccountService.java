package com.myorg.accountenquiry.service;

import com.myorg.accountenquiry.domain.Account;

import java.util.List;

public interface AccountService {

    List<Account> getAccounts(String userId);

}
