package com.my.kiosk.repository;

import com.my.kiosk.entity.QAccountEntity;
import com.my.kiosk.entity.QTransactionEntity;
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
        QAccountEntity accountEntitySender = QAccountEntity.accountEntity;
        QAccountEntity accountEntityReceiver = QAccountEntity.accountEntity;

        return jpaQueryFactory.from(transactionEntity)
                .select(bean(TransactionVo.class,
                        transactionEntity.id,
                        transactionEntity.amount,
                        transactionEntity.description,
                        transactionEntity.date,
                        accountEntitySender.user.firstName.as("senderFirstName"),
                        accountEntitySender.user.lastName.as("senderLastName"),
                        accountEntityReceiver.user.firstName.as("receiverFirstName"),
                        accountEntityReceiver.user.lastName.as("receiverLastName")))
                .innerJoin(transactionEntity.senderAccount, accountEntitySender)
                .innerJoin(transactionEntity.receiverAccount, accountEntityReceiver)
                .where(transactionEntity.id.eq(id))
                .fetchFirst();
    }
}
