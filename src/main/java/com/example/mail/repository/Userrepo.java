package com.example.mail.repository;

import com.example.mail.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Userrepo extends JpaRepository<User, Long> {
}
