package com.amardeep.portfolio.service;

import com.amardeep.portfolio.dto.ContactRequest;
import com.amardeep.portfolio.model.ContactMessage;
import com.amardeep.portfolio.repository.ContactMessageRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ContactService {

    private final ContactMessageRepository repository;

    public ContactService(ContactMessageRepository repository) {
        this.repository = repository;
    }

    public void saveContact(ContactRequest request) {
        ContactMessage msg = new ContactMessage();
        msg.setName(request.getName());
        msg.setEmail(request.getEmail());
        msg.setSubject(request.getSubject());
        msg.setMessage(request.getMessage());
        msg.setCreatedAt(LocalDateTime.now());

        repository.save(msg);
    }
}
