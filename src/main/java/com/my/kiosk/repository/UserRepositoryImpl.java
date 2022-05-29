package com.my.kiosk.repository;

import com.my.kiosk.entity.QAccountEntity;
import com.my.kiosk.entity.QUserEntity;
import com.my.kiosk.entity.UserEntity;
import com.my.kiosk.vo.LoginVo;
import com.my.kiosk.vo.UserVo;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static com.querydsl.core.types.Projections.bean;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Override
    public UserEntity findById(Long id) {
        return null;
    }

    @Override
    public UserVo findByLogin(LoginVo loginVo) {
        QUserEntity userEntity = QUserEntity.userEntity;
        QAccountEntity accountEntity = QAccountEntity.accountEntity;
        return jpaQueryFactory.from(userEntity)
                .select(bean(UserVo.class,
                        userEntity.id,
                        userEntity.firstName,
                        userEntity.lastName,
                        userEntity.username,
                        accountEntity.id.as("accountId"),
                        accountEntity.amount))
                .innerJoin(userEntity.accountSet, accountEntity)
                .where(userEntity.username.eq(loginVo.getUsername()).
                        and(userEntity.password.eq(loginVo.getPassword())))
                .fetchFirst();
    }
}
