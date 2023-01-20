package ru.practicum.statistics.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ViewStats {
    @NotNull
    private String app;
    @NotNull
    private String uri;
    @NotBlank
    private Integer hits;
}
