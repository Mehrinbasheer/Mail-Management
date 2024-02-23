package com.example.mail.Controller;

import com.example.mail.Services.LabelsMailService;
import com.example.mail.entity.LabelMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LabelsMailController {
   private final LabelsMailService labelsMailService;

    @Autowired
    public LabelsMailController(LabelsMailService labelsMailService)
    {
        this.labelsMailService = labelsMailService;
    }

    @GetMapping("/getalllabelmail")
    public List<LabelMail> getAllLabelMail() {
        return labelsMailService.getAllLabelMails();
    }

    @GetMapping("/labelmailget/{labelMailId}")
    public Optional<LabelMail> getLabelMailById(@PathVariable Long labelMailId) {
        return labelsMailService.getLabelMailsById(labelMailId);
    }

    @PostMapping("/labelmail")
    public LabelMail createLabelMail(@RequestBody LabelMail labelMail) {
        return labelsMailService.createLabelMail(labelMail);
    }

    @PutMapping("/labelmailupdate/{labelMailId}")
    public LabelMail updateLabelMail(@PathVariable Long labelMailId, @RequestBody LabelMail updatedLabelMail) {
        return labelsMailService.updateLabelMail(labelMailId, updatedLabelMail);
    }

    @DeleteMapping("/labelmaildelete/{labelMailId}")
    public boolean deleteLabelMail(@PathVariable Long labelMailId) {
        return labelsMailService.deleteLabelMail(labelMailId);
    }
}
