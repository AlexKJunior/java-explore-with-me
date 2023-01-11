package ru.practicum.ewm.client.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EndPointHit {
    Long id;
    @NotBlank
    String uri;
    @NotBlank
    String app;
    @NotBlank
    String ip;
    String timestamp;
    Long hits;
}
