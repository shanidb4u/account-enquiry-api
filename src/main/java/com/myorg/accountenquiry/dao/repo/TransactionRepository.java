package com.myorg.accountenquiry.dao.repo;

import com.myorg.accountenquiry.domain.entity.TransactionEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransactionRepository extends CrudRepository<TransactionEntity, Long> {

    List<TransactionEntity> findByAccount_AccountNumber(String accountNumber);


}
