package com.meritamerica.MeritBankAppCapstone.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Date openendOn;

    private String type;

    private long sourceAccountId;

    private long destinationAccountId;

    private double amount;

    @ManyToOne
    private AccountHolder accountHolder;

}
