package com.example.mail.Services;

import com.example.mail.entity.Mailbox;
import com.example.mail.repository.Mailboxrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MailboxService {
    private final Mailboxrepo mailboxrepo;

    @Autowired
    public MailboxService(Mailboxrepo mailboxrepo) {
        this.mailboxrepo = mailboxrepo;
    }

    public Optional<Mailbox> getMailboxById(Long mailboxId) {
        return mailboxrepo.findById(mailboxId);
    }

    public Mailbox createMailbox(Mailbox mailbox) {
        return mailboxrepo.save(mailbox);
    }

    public Mailbox updateMailbox(Long mailboxId, Mailbox updatedMailbox) {
        Optional<Mailbox> existingMailbox = mailboxrepo.findById(mailboxId);
        if (existingMailbox.isPresent()) {
            Mailbox mailboxToUpdate = existingMailbox.get();
            mailboxToUpdate.setName(updatedMailbox.getName());
            return mailboxrepo.save(mailboxToUpdate);
        } else {
            return null;
        }
    }

    public void deleteMailbox(Long mailboxId) {
        mailboxrepo.deleteById(mailboxId);
    }

    public List<Mailbox> getAllMailbox() {
        return mailboxrepo.findAll();
    }
}







