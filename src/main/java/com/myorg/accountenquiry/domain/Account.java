package com.myorg.accountenquiry.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private Long accountId;
    private String accountName;
    private String accountNumber;
    private String accountType;
    private LocalDate balanceDate;
    private Double openingBalance;
    private String currency;
}
