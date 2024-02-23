package com.example.mail.Controller;

import com.example.mail.Services.MailboxService;
import com.example.mail.entity.Mailbox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class MailboxController {
    private final MailboxService mailboxservice;

    @Autowired
    public MailboxController(MailboxService mailboxservice) {

        this.mailboxservice = mailboxservice;
    }

    @GetMapping("/getallmailbox")
    public List<Mailbox> getAllMailbox() {
        return mailboxservice.getAllMailbox();
    }

    @GetMapping("/mailboxget/{mailboxId}")
    public Mailbox getMailboxById(@PathVariable Long mailboxId) {
        return mailboxservice.getMailboxById(mailboxId).orElse(null);
    }

    @PostMapping("/mailbox")
    public Mailbox createMailbox(@RequestBody Mailbox mailbox) {
        return mailboxservice.createMailbox(mailbox);
    }

    @PutMapping("/mailboxupdate/{mailboxId}")
    public Mailbox updateMailbox(@PathVariable Long mailboxId, @RequestBody Mailbox updatedMailbox) {
        return mailboxservice.updateMailbox(mailboxId, updatedMailbox);
    }

    @DeleteMapping("/mailboxdelete/{mailboxId}")
    public String deleteMailbox(@PathVariable Long mailboxId) {
        mailboxservice.deleteMailbox(mailboxId);
        return "deleted mailbox successfully ";
    }
}

