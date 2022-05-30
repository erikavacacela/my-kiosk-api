package com.my.kiosk.controller;

import com.my.kiosk.service.TransactionService;
import com.my.kiosk.vo.ErrorMessageVo;
import com.my.kiosk.vo.PaymentVo;
import com.my.kiosk.vo.TransactionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

@RestController
@RequestMapping("/v1/transactions")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping(path = "/payment",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Object> payment(@RequestBody PaymentVo paymentVo) {
        try {
            TransactionVo transactionVo = transactionService.sendPayment(paymentVo);
            return ResponseEntity.ok(transactionVo);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ErrorMessageVo.builder().errorMessage(ex.getMessage()).build());
        }
    }

    @GetMapping(value = "/findByAccount/{accountId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Collection<TransactionVo>> findById(@PathVariable Long accountId) {
        Collection<TransactionVo> transactionVoCollection = transactionService.findByAccount(accountId);
        return Map.of("transactions", transactionVoCollection);
    }

}
