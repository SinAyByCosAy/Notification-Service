package dev.tanay.notificationservice.MessageQueueConfig;

import dev.tanay.notificationservice.dtos.EmailMessageDto;
import dev.tanay.notificationservice.services.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserSignupListener {
    private final EmailService emailService;

    @KafkaListener(
            topics = "user-signup-topic",
            groupId = "notification-group"
    )
    public void consume(EmailMessageDto msg){
        emailService.sendWelcomeEmail(
                msg.getEmail(),
                msg.getUsername()
        );
    }
}
