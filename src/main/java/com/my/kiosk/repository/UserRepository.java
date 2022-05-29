package com.my.kiosk.repository;

import com.my.kiosk.entity.UserEntity;
import com.my.kiosk.vo.LoginVo;
import com.my.kiosk.vo.UserVo;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository {

    UserEntity findById(Long id);

    UserVo findByLogin(LoginVo loginVo);

}
