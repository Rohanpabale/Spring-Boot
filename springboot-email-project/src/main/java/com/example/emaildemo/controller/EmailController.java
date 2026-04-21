package com.example.emaildemo.controller;

import com.example.emaildemo.service.EmailService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/send")
    public String sendEmail(@RequestParam String to) {
        emailService.sendEmail(to, "Test Subject", "Hello from Spring Boot!");
        return "Email sent successfully!";
    }
}
