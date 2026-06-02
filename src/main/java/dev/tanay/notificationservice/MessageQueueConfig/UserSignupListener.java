package dev.tanay.notificationservice.MessageQueueConfig;

import com.google.protobuf.InvalidProtocolBufferException;
import dev.tanay.events.EmailMessage;
import dev.tanay.notificationservice.services.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserSignupListener {
    private final EmailService emailService;

    @KafkaListener(
            topics = "user-signup-topic"
    )
    public void consume(
            byte[] payload
    ) throws InvalidProtocolBufferException {
        EmailMessage msg =
                EmailMessage.parseFrom(payload);

        System.out.println("Message Received: "+msg);

        emailService.sendWelcomeEmail(
                msg.getEmail(),
                msg.getUsername()
        );
    }
}
