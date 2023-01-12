package ru.practicum.statistics.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.practicum.statistics.model.Hit;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface StatisticDao extends JpaRepository<Hit, Long> {

    List<Hit> findAllByTimestampBetweenAndUriIn(LocalDateTime start, LocalDateTime end, String[] uris);

    @Query("SELECT COUNT (ip) FROM Hit " +
            "WHERE uri = ?1")
    Integer findHitCountByUri(String start, String end,String[] uri);

    @Query("SELECT COUNT (DISTINCT ip) FROM Hit " +
            "WHERE uri = ?1")
    Integer findHitCountByUriWithUniqueIpAndUriIn(String start, String end,String[] uri);
}
