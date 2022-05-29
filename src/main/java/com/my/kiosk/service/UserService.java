package com.my.kiosk.service;

import com.my.kiosk.entity.UserEntity;
import com.my.kiosk.repository.UserRepository;
import com.my.kiosk.vo.LoginVo;
import com.my.kiosk.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserEntity findById(Long id) {
        return userRepository.findById(id);
    }

    public UserVo verifyLogin(LoginVo loginVo) {
        return userRepository.findByLogin(loginVo);
    }
}
