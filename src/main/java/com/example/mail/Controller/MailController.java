package com.example.mail.Controller;

import com.example.mail.Services.MailService;
import com.example.mail.entity.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController

public class MailController {
    private final MailService mailService;

    @Autowired
    public MailController(MailService mailService) {

        this.mailService = mailService;
    }

    @GetMapping("/getallmails")
    public List<Mail> getAllMails() {
        return mailService.getAllMails();
    }

    @GetMapping("/mails/{mailId}")
    public Optional<Mail> getMailById(@PathVariable Long mailId) {
        return mailService.getMailById(mailId);
    }

    @PostMapping
    public Mail createMail(@RequestBody Mail mail) {
        return mailService.createMail(mail);
    }

    @PutMapping("mailupdate/{mailId}")
    public Mail updateMail(@PathVariable Long mailId, @RequestBody Mail updatedMail) {
        return mailService.updateMail(mailId, updatedMail);
    }


    @DeleteMapping("maildelete/{mailId}")
    public String deleteMail(@PathVariable Long mailId) {
        mailService.deleteMail(mailId);
        return " deleted mail successfully..";
    }
}