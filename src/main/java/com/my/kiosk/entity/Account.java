package com.my.kiosk.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "user_id", nullable = false)
    private Long user_id;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    @OneToMany(mappedBy="sender_account")
    private Set<Transaction> senderTransactionSet;

    @OneToMany(mappedBy="receiver_account")
    private Set<Transaction> receiverTransactionSet;
}
