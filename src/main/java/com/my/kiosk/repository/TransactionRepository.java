package com.my.kiosk.repository;

import com.my.kiosk.entity.TransactionEntity;
import com.my.kiosk.vo.TransactionVo;
import org.springframework.stereotype.Repository;


@Repository
public interface TransactionRepository {

    Long save(TransactionEntity transactionEntity);

    TransactionVo findById(Long id);

}
