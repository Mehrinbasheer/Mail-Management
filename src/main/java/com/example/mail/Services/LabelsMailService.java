package com.example.mail.Services;

import com.example.mail.entity.LabelMail;
import com.example.mail.repository.LabelsMailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LabelsMailService {
    private final LabelsMailRepo labelsMailRepo;

    @Autowired
    public LabelsMailService(LabelsMailRepo labelsMailRepo) {
        // Constructor to initialize the service with a repository.
        this.labelsMailRepo = labelsMailRepo;
    }

    public List<LabelMail> getAllLabelMails() {
        // Retrieve all label mails from the repository.
        return labelsMailRepo.findAll();
    }

    public Optional<LabelMail> getLabelMailsById(Long labelMailId) {
        // Retrieve a label mail by its unique ID.
        return labelsMailRepo.findById(labelMailId);
    }

    public LabelMail createLabelMail(LabelMail labelmail) {
        // Create and save a new label mail in the repository.
        return labelsMailRepo.save(labelmail);
    }

    public LabelMail updateLabelMail(Long labelMailId, LabelMail updatedLabelMail) {
        // Update an existing label mail with new data.
        // Returns the updated label mail or null if not found.
        Optional<LabelMail> existingLabelMail = labelsMailRepo.findById(labelMailId);
        if (existingLabelMail.isPresent()) {
            LabelMail labelMail = existingLabelMail.get();
            labelMail.setMail(updatedLabelMail.getMail());
            return labelsMailRepo.save(labelMail);
        } else {
            return null;
        }
    }

    public boolean deleteLabelMail(Long labelMailId) {
        // Delete a label mail by its ID, return true if successful, false if not found.
        if (labelsMailRepo.existsById(labelMailId)) {
            labelsMailRepo.deleteById(labelMailId);
            return true;
        } else {
            return false;
        }
    }
}


