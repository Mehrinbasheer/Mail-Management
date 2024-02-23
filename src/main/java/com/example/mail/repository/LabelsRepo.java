package com.example.mail.repository;

import com.example.mail.entity.Labels;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LabelsRepo extends JpaRepository<Labels, Long> {
}
