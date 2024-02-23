package com.example.mail.Services;

import com.example.mail.entity.Labels;
import com.example.mail.repository.LabelsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LabelsService {
    private final LabelsRepo labelRepo;

    @Autowired
    public LabelsService(LabelsRepo labelRepo) {
        this.labelRepo = labelRepo;
    }

    public List<Labels> getAllLabels() {
        return labelRepo.findAll();
    }

    public Optional<Labels> getLabelsById(Long labelId) {
        return labelRepo.findById(labelId);
    }

    public Labels createLabel(Labels label) {
        return labelRepo.save(label);
    }

    public Labels updateLabels(Long labelId, Labels updatedLabels) {
        Optional<Labels> existingLabel = labelRepo.findById(labelId);
        if (existingLabel.isPresent()) {
            Labels labels = existingLabel.get();
            labels.setName(updatedLabels.getName());
            labels.setUser(updatedLabels.getUser());
            return labelRepo.save(labels);
        } else {
            return null;
        }
    }

    public boolean deleteLabel(Long labelId) {
        if (labelRepo.existsById(labelId)) {
            labelRepo.deleteById(labelId);
            return true;
        } else {
            return false;
        }
    }
}
