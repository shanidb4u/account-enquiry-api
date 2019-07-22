package com.myorg.accountenquiry.dao.repo;

import com.myorg.accountenquiry.domain.entity.AccountEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountRepository extends CrudRepository<AccountEntity, Long> {
    List<AccountEntity> findByUserId(String userId);
}
