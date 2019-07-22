package com.myorg.accountenquiry.domain.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "account_info")
public class AccountEntity {
    @Id
    private Long accountId;
    private String userId;
    private String accountName;
    private String accountNumber;
    private String accountType;
    private LocalDate balanceDate;
    private Double openingBalance;
    private String currency;
}
