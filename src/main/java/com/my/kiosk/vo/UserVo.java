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
public class UserVo implements Serializable {

    private Long id;

    private String firstName;

    private String lastName;

    private String username;

    private Long accountId;

    private Double amount;

}
