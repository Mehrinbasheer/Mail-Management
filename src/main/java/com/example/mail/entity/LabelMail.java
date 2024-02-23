package com.example.mail.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "label_mail")
public class LabelMail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "label_mail_id")
    private Long labelMailId;

    @ManyToOne
    @JoinColumn(name = "label_id")
    private Labels label;

    @ManyToOne
    @JoinColumn(name = "mail_id")
    private Mail mail;
}
