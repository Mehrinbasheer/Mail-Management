package com.example.mail.repository;

import com.example.mail.entity.LabelMail;
import org.springframework.data.jpa.repository.JpaRepository;

// This interface provides data access operations for LabelMail entities.
public interface LabelsMailRepo extends JpaRepository<LabelMail, Long> {
}
