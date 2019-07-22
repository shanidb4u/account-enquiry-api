package com.myorg.accountenquiry.converter;

import com.myorg.accountenquiry.domain.Account;
import com.myorg.accountenquiry.domain.entity.AccountEntity;

import java.util.List;
import java.util.stream.Collectors;

public class AccountConverter {

    private AccountConverter() {
    }

    public static List<Account> toAccounts(List<AccountEntity> accountEntities) {
        return accountEntities.stream()
                .map(AccountConverter::mapAccountEntityToAccount)
                .collect(Collectors.toList());
    }

    private static Account mapAccountEntityToAccount(AccountEntity accountEntity) {
        return Account.builder()
                .accountId(accountEntity.getAccountId())
                .accountName(accountEntity.getAccountName())
                .accountNumber(accountEntity.getAccountNumber())
                .accountType(accountEntity.getAccountType())
                .balanceDate(accountEntity.getBalanceDate())
                .currency(accountEntity.getCurrency())
                .openingBalance(accountEntity.getOpeningBalance())
                .build();
    }

}
