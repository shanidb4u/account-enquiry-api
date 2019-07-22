package com.myorg.accountenquiry.service;

import com.myorg.accountenquiry.dao.AccountDao;
import com.myorg.accountenquiry.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    AccountDao accountDao;

    @Autowired
    public AccountService(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> getAccounts(String userId) {
        return accountDao.getAccounts(userId);
    }

}
