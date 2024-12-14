package com.example.fortunex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import jakarta.mail.internet.MimeMessage;

@RestController
@CrossOrigin("*")
public class EmailController {
    
        @Autowired
        private JavaMailSender mailSender;
    
        @PostMapping("/send-email")
        public ResponseEntity<String> sendEmail(
            @RequestParam("from_name") String fromName,
            @RequestParam("reply_to") String replyTo,
            @RequestParam("message") String message,
            @RequestParam(value = "phone", required = false) String phone,
            @RequestParam(value = "attachment", required = false) MultipartFile attachment
        ) {
            try {
                // Create a new MIME message
                MimeMessage mimeMessage = mailSender.createMimeMessage();
                MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
    
                // Set the sender and recipient email addresses
                helper.setFrom(replyTo); // Use the user's email as the sender's email
                helper.setTo("coderayush001@gmail.com"); // Send email to this address
                helper.setSubject("Contact Form Submission");
    
                // Build the email body
                StringBuilder emailContent = new StringBuilder();
                emailContent.append("Name: ").append(fromName).append("\n");
                emailContent.append("Email: ").append(replyTo).append("\n");
                if (phone != null && !phone.isEmpty()) {
                    emailContent.append("Phone: ").append(phone).append("\n");
                }
                emailContent.append("Message: ").append(message).append("\n");
    
                helper.setText(emailContent.toString());
    
                // Add the attachment if it exists
                if (attachment != null) {
                    helper.addAttachment(attachment.getOriginalFilename(),
                            new ByteArrayResource(attachment.getBytes()));
                }
    
                // Send the email
                mailSender.send(mimeMessage);
    
                // Return success response
                return ResponseEntity.ok("Email sent successfully.");
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.status(500).body("Error sending email.");
            }
        }
    }
    