package ru.practicum.statistics.dto;

import lombok.*;
import ru.practicum.statistics.model.Hit;

import javax.validation.constraints.NotBlank;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ViewStats {

    @NotBlank
    private String app;
    @NotBlank
    private String uri;
    @NotBlank
    private Integer hits;
}
