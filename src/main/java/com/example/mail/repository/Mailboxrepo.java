package com.example.mail.repository;

import com.example.mail.entity.Mailbox;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Mailboxrepo extends JpaRepository<Mailbox, Long> {
}
