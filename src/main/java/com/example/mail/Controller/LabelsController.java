package com.example.mail.Controller;

import com.example.mail.Services.LabelsService;
import com.example.mail.entity.Labels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LabelsController {
    private final LabelsService labelsService;

    @Autowired
    public LabelsController(LabelsService labelsService) {
        // Constructor to initialize the controller with a LabelsService instance.
        this.labelsService = labelsService;
    }

    @GetMapping("/getalllabels")
    public List<Labels> getAllLabels() {
        // Get all labels and return them.
        return labelsService.getAllLabels();
    }

    @GetMapping("/labelsget/{labelId}")
    public Optional<Labels> getLabelsById(@PathVariable Long labelId) {
        // Get a label by ID and return it if found.
        return labelsService.getLabelsById(labelId);
    }

    @PostMapping("/label")
    public Labels createLabel(@RequestBody Labels labels) {
        // Create and save a new label, then return it.
        return labelsService.createLabel(labels);
    }

    @PutMapping("/labelupdate/{labelId}")
    // Update an existing label and return the updated version.
    public Labels updateLabel(@PathVariable Long labelId, @RequestBody Labels updatedLabels) {
        return labelsService.updateLabels(labelId, updatedLabels);
    }

    @DeleteMapping("/labeldelete/{labelId}")
    public boolean deleteLabel(@PathVariable Long labelId) {
        // Delete a label by its ID
        return labelsService.deleteLabel(labelId);
    }
}

