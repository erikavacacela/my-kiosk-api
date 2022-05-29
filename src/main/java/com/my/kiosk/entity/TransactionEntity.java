package com.my.kiosk.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="transaction")
public class TransactionEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "date", nullable = false)
    private Timestamp date;

    @Column(name = "sender_account_id", nullable = false)
    private Long senderAccountId;

    @Column(name = "receiver_account_id", nullable = false)
    private Long receiverAccountId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="sender_account_id", nullable=false, insertable = false, updatable = false)
    private AccountEntity senderAccount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="receiver_account_id", nullable=false, insertable = false, updatable = false)
    private AccountEntity receiverAccount;

}
