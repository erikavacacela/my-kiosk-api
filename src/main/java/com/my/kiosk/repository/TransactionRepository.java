package com.my.kiosk.repository;

import com.my.kiosk.entity.TransactionEntity;
import com.my.kiosk.vo.TransactionVo;
import org.springframework.stereotype.Repository;

import java.util.Collection;


@Repository
public interface TransactionRepository {

    Long save(TransactionEntity transactionEntity);

    TransactionVo findById(Long id);

    Collection<TransactionVo> findByAccount(Long accountId);

}
