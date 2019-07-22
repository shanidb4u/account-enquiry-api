package com.myorg.accountenquiry.controller;

import com.myorg.accountenquiry.domain.Account;
import com.myorg.accountenquiry.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class AccountController {

    AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping(value = "/accounts")
    public List<Account> getAccounts(@RequestHeader(value = "userId") String userId) {
        log.info(AccountController.class.getName()+":"+"getAccounts() for "+ userId);
        return accountService.getAccounts(userId);
    }

}
