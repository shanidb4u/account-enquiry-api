package com.myorg.accountenquiry.controller;

import com.myorg.accountenquiry.domain.Transaction;
import com.myorg.accountenquiry.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.myorg.accountenquiry.constant.ApiConstant.ERR_MSG_ACCOUNT_NUMBER_SHOULD_NOT_BE_BLANK;
import static org.springframework.util.Assert.hasText;

@RestController
@Slf4j
public class TransactionController {

    TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping(value = "/account/{accountNumber}/transactions")
    public List<Transaction> getTransactions(@PathVariable String accountNumber) {
        log.info(TransactionController.class.getName() + ":" + "getTransactions()" + " For Account Number:" + accountNumber);
        hasText(accountNumber, ERR_MSG_ACCOUNT_NUMBER_SHOULD_NOT_BE_BLANK);
        return transactionService.getTransactions(accountNumber);
    }

}
