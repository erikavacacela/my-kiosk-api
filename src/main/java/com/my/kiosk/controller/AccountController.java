package com.my.kiosk.controller;

import com.my.kiosk.service.AccountService;
import com.my.kiosk.vo.AccountVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/accounts")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping(value = "/findByUser/{user_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public AccountVo findById(@PathVariable Long user_id) {
        return accountService.findByUser(user_id);
    }

}
