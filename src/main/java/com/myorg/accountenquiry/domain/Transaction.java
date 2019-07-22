package com.myorg.accountenquiry.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    private Long transactionId;
    private String accountName;
    private String accountNumber;
    private LocalDate valueDate;
    private String currency;
    private Double amount;
    private String transactionType;
    private String transactionNarrative;
}
