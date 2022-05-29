package com.my.kiosk.service;

import com.my.kiosk.entity.AccountEntity;
import com.my.kiosk.entity.TransactionEntity;
import com.my.kiosk.repository.AccountRepository;
import com.my.kiosk.repository.TransactionRepository;
import com.my.kiosk.vo.AccountVo;
import com.my.kiosk.vo.PaymentVo;
import com.my.kiosk.vo.TransactionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Objects;

@Service
public class TransactionService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    TransactionRepository transactionRepository;

    @Transactional
    public TransactionVo sendPayment(PaymentVo paymentVo) {
        AccountEntity senderAccountEntity = accountRepository.findById(paymentVo.getSenderAccountId());
        if (Objects.isNull(senderAccountEntity)
                || senderAccountEntity.getAmount().compareTo(paymentVo.getAmount()) < 0) {
            throw new RuntimeException("Saldo insuficiente!");
        }
        TransactionEntity transactionEntity = TransactionEntity.builder()
                .amount(paymentVo.getAmount())
                .description(paymentVo.getDescription())
                .date(new Timestamp(System.currentTimeMillis()))
                .senderAccountId(paymentVo.getSenderAccountId())
                .receiverAccountId(paymentVo.getReceiverAccountId())
                .build();
        transactionRepository.save(transactionEntity);

        Double senderNewAmount = senderAccountEntity.getAmount() - paymentVo.getAmount();
        accountRepository.updateAmount(senderAccountEntity.getId(), senderNewAmount);

        AccountEntity receiverAccountEntity = accountRepository.findById(transactionEntity.getReceiverAccountId());
        Double newAmount = receiverAccountEntity.getAmount() + paymentVo.getAmount();
        accountRepository.updateAmount(receiverAccountEntity.getId(), newAmount);

        TransactionVo transactionVo = transactionRepository.findById(transactionEntity.getId());
        transactionVo.setNewAmount(newAmount);
        return transactionVo;
    }

    public AccountVo findByUser(Long userId) {
        return accountRepository.findByUser(userId);
    }

}
