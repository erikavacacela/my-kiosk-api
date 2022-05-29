package com.my.kiosk.vo;

import com.querydsl.core.annotations.QueryEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@QueryEntity
public class PaymentVo implements Serializable {

    private Double amount;

    private String description;

    private Long senderAccountId;

    private Long receiverAccountId;

}
