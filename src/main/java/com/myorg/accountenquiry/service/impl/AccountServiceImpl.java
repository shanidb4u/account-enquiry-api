package com.myorg.accountenquiry.service.impl;

import com.myorg.accountenquiry.repo.AccountRepository;
import com.myorg.accountenquiry.domain.Account;
import com.myorg.accountenquiry.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.myorg.accountenquiry.converter.AccountConverter.toAccounts;

@Service
public class AccountServiceImpl implements AccountService {

    AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> getAccounts(String userId) {
        return toAccounts(accountRepository.findByUserId(userId));
    }

}
