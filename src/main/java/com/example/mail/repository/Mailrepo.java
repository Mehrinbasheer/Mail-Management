package com.example.mail.repository;

import com.example.mail.entity.Mail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Mailrepo extends JpaRepository<Mail, Long> {
}
