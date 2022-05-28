package com.my.kiosk.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "date", nullable = false)
    private Timestamp date;

    @Column(name = "sender_account_id", nullable = false)
    private Long sender_account_id;

    @Column(name = "receiver_account_id", nullable = false)
    private Long receiver_account_id;

    @ManyToOne
    @JoinColumn(name="sender_account_id", nullable=false)
    private Account sender_account;

    @ManyToOne
    @JoinColumn(name="receiver_account_id", nullable=false)
    private Account receiver_account;

}
