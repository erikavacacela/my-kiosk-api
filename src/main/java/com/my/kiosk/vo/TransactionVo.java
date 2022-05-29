package com.my.kiosk.vo;

import com.querydsl.core.annotations.QueryEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@QueryEntity
public class TransactionVo implements Serializable {

    private Long id;

    private Double amount;

    private String description;

    private Timestamp date;

    private String senderFirstName;

    private String senderLastName;

    private String receiverFirstName;

    private String receiverLastName;

    private Double newAmount;
}
