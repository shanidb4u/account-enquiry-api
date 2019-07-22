package com.myorg.accountenquiry.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "transaction_details")
public class TransactionEntity {
    @Id
    private Long transactionId;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accountId")
    private AccountEntity account;
    private LocalDate valueDate;
    private String currency;
    private Double amount;
    private String transactionType;
    private String transactionNarrative;
}
