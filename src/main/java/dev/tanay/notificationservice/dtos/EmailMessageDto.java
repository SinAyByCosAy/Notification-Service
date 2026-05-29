package dev.tanay.notificationservice.dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class EmailMessageDto {
    private Long id;
    private String username;
    private String email;
}
