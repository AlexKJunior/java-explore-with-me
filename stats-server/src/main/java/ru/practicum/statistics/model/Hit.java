package ru.practicum.statistics.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;


@Entity
@Table(name = "hits")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder(toBuilder = true)
public class Hit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotBlank
    @Size(max = 500)
    @Column
    String uri;
    @NotNull
    @NotBlank
    @Size(max = 100)
    @Column
    String app;
    @NotNull
    @NotBlank
    @Size(max = 32)
    @Column
    String ip;
    @Column
    LocalDateTime timestamp;
}
