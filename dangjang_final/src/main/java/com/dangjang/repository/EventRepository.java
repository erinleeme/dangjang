package com.dangjang.repository;

import com.dangjang.domain.Event;
import com.dangjang.domain.type.EventStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface EventRepository extends JpaRepository<Event, Long> {
    @Query("select e from Event e where e.eventStatus = :eventStatus order by e.createDate")
    List<Event> findAllByEventStatusOrderByCreateDate(@Param("eventStatus") EventStatus eventStatus);

}
