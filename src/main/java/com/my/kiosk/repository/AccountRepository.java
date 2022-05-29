package com.my.kiosk.repository;

import com.my.kiosk.entity.AccountEntity;
import com.my.kiosk.vo.AccountVo;
import org.springframework.stereotype.Repository;


@Repository
public interface AccountRepository {

    AccountEntity findById(Long id);

    AccountVo findByUser(Long userId);

    void updateAmount(Long id, Double newAmount);

}
