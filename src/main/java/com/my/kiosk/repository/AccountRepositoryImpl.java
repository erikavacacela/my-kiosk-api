package com.my.kiosk.repository;

import com.my.kiosk.entity.AccountEntity;
import com.my.kiosk.entity.QAccountEntity;
import com.my.kiosk.vo.AccountVo;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static com.querydsl.core.types.Projections.bean;

@Repository
public class AccountRepositoryImpl implements AccountRepository {

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Override
    public AccountEntity findById(Long id) {
        QAccountEntity qAccountEntity = QAccountEntity.accountEntity;
        return jpaQueryFactory.selectFrom(qAccountEntity)
                .where(qAccountEntity.id.eq(id))
                .fetchFirst();
    }

    @Override
    public AccountVo findByUser(Long userId) {
        QAccountEntity accountEntity = QAccountEntity.accountEntity;
        return jpaQueryFactory.from(accountEntity)
                .where(accountEntity.userId.eq(userId))
                .select(bean(AccountVo.class,
                        accountEntity.id,
                        accountEntity.amount))
                .fetchFirst();
    }

    @Override
    public void updateAmount(Long id, Double newAmount) {
        QAccountEntity qAccountEntity = QAccountEntity.accountEntity;
        jpaQueryFactory.update(qAccountEntity)
                .set(qAccountEntity.amount, newAmount)
                .where(qAccountEntity.id.eq(id))
                .execute();
    }
}
