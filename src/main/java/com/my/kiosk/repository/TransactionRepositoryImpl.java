package com.my.kiosk.repository;

import com.my.kiosk.entity.QAccountEntity;
import com.my.kiosk.entity.QTransactionEntity;
import com.my.kiosk.entity.QUserEntity;
import com.my.kiosk.entity.TransactionEntity;
import com.my.kiosk.vo.TransactionVo;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

import static com.querydsl.core.types.Projections.bean;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository {

    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Autowired
    private EntityManager entityManager;

    @Override
    public Long save(TransactionEntity transactionEntity) {
        entityManager.persist(transactionEntity);
        entityManager.flush();
        return transactionEntity.getId();
    }

    @Override
    public TransactionVo findById(Long id) {
        QTransactionEntity transactionEntity = QTransactionEntity.transactionEntity;

        return jpaQueryFactory
                .from(transactionEntity)
                .select(bean(TransactionVo.class,
                        transactionEntity.id,
                        transactionEntity.amount,
                        transactionEntity.description,
                        transactionEntity.date,
                        transactionEntity.senderAccount.user.firstName.as("senderFirstName"),
                        transactionEntity.senderAccount.user.lastName.as("senderLastName"),
                        transactionEntity.receiverAccount.user.firstName.as("receiverFirstName"),
                        transactionEntity.receiverAccount.user.lastName.as("receiverLastName")))
                .innerJoin(transactionEntity.senderAccount)
                .innerJoin(transactionEntity.receiverAccount)
                .innerJoin(transactionEntity.senderAccount.user)
                .innerJoin(transactionEntity.receiverAccount.user)
                .where(transactionEntity.id.eq(id))
                .fetchFirst();
    }
}
