package ru.practicum.ewm.event.model;

import lombok.*;
import ru.practicum.ewm.category.model.Category;
import ru.practicum.ewm.event.EventState;
import ru.practicum.ewm.user.model.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.Set;
import java.time.LocalDateTime;


@Entity
@Table(name = "events")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder(toBuilder = true)
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(max = 1000)
    @Column(length = 1000)
    private String annotation;
    @NotNull
    @Size(max = 2000)
    @Column(length = 2000)
    private String description;
    @Column(name = "confirmed_requests")
    private Integer confirmedRequests;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @NotNull
    @Size(max = 200)
    @Column(length = 200)
    private String title;
    @Column(name = "published_on")
    private LocalDateTime publishedOn;
    @Column(name = "event_date")
    private LocalDateTime eventDate;
    @ManyToOne
    @JoinColumn(name = "initiator_id")
    private User initiator;
    @Column
    private Double lat;
    @Column
    private Double lon;
    @Column
    private Boolean paid;
    @Column(name = "participant_limit")
    private Integer participantLimit;
    @Column(name = "request_moderation")
    private Boolean requestModeration;
    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    private EventState state;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "events_likes",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    Set<User> userLikes;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "events_dislikes",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    Set<User> userDislikes;
}