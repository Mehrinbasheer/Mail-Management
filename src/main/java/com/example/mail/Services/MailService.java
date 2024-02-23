package com.example.mail.Services;

import com.example.mail.entity.Mail;
import com.example.mail.repository.Mailrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MailService {
    private final Mailrepo mailRepo;

    @Autowired
    public MailService(Mailrepo mailRepo) {
        this.mailRepo = mailRepo;
    }


    public Optional<Mail> getMailById(Long mailId) {
        return mailRepo.findById(mailId);
    }

    public Mail createMail(Mail mail) {
        return mailRepo.save(mail);
    }

    public Mail updateMail(Long mailId, Mail updatedMail) {
        Optional<Mail> existingMail = mailRepo.findById(mailId);
        if (existingMail.isPresent()) {
            Mail mailToUpdate = existingMail.get();
            mailToUpdate.setSubject(updatedMail.getSubject());
            mailToUpdate.setContent(updatedMail.getContent());
            mailToUpdate.setSender(updatedMail.getSender());
            mailToUpdate.setReceiver(updatedMail.getReceiver());
            mailToUpdate.setMailbox(updatedMail.getMailbox());
            return mailRepo.save(mailToUpdate);
        } else {
            return null;
        }
    }

    public String deleteMail(Long mailId) {
        mailRepo.deleteById(mailId);
        return null;
    }

    public List<Mail> getAllMails() {
        return mailRepo.findAll();
    }
}

