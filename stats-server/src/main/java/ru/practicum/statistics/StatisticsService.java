package ru.practicum.statistics;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.practicum.statistics.dao.StatisticDao;
import ru.practicum.statistics.dto.EndPointHit;
import ru.practicum.statistics.dto.ViewStats;
import ru.practicum.statistics.mapper.EndPointHitMapper;
import ru.practicum.statistics.model.Hit;
import ru.practicum.statistics.utility.Constants;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class StatisticsService {
    private final StatisticDao statDao;

    public List<ViewStats> getStatistic(String start, String end, String[] uris, Boolean unique) {
        List<Hit> hits = statDao.findAllByTimestampBetweenAndUriIn(LocalDateTime
                .parse(start, Constants.TIME_FORMATTER), LocalDateTime.parse(end, Constants.TIME_FORMATTER), uris);
        List<ViewStats> viewStats = new ArrayList<>();
        if (unique) {
            return statDao.findHitCountByUriWithUniqueIp(start, end, uris);
        } else {
            return statDao.findHitCountByUri(start, end, uris);
        }

    }

    public void addHit(EndPointHit endpointHit) {
        statDao.save(EndPointHitMapper.toHit(endpointHit));
    }

    public List<ViewStats> findEventViews(String start, String end, String[] uris, Boolean unique) {
        return getStatistic(start, end, uris, unique);
    }
}
