package com.my.kiosk.service;

import com.my.kiosk.repository.AccountRepository;
import com.my.kiosk.vo.AccountVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public AccountVo findByUser(Long userId) {
        return accountRepository.findByUser(userId);
    }

}
