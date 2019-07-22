package com.myorg.accountenquiry.dao.impl;

import com.myorg.accountenquiry.converter.AccountConverter;
import com.myorg.accountenquiry.dao.AccountDao;
import com.myorg.accountenquiry.dao.repo.AccountRepository;
import com.myorg.accountenquiry.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDaoImpl implements AccountDao {

    AccountRepository accountRepository;

    @Autowired
    public AccountDaoImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> getAccounts(String userId) {
        return AccountConverter.toAccounts(accountRepository.findByUserId(userId));
    }
}
