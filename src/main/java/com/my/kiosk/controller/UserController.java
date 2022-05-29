package com.my.kiosk.controller;

import com.my.kiosk.entity.UserEntity;
import com.my.kiosk.service.UserService;
import com.my.kiosk.vo.LoginVo;
import com.my.kiosk.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(path = "/login",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public UserVo login(@RequestBody LoginVo loginVo) {
        return userService.verifyLogin(loginVo);
    }

}
