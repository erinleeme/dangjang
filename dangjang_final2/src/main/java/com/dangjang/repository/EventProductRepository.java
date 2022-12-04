package com.dangjang.repository;

import com.dangjang.domain.Event;
import com.dangjang.domain.EventProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EventProductRepository extends JpaRepository<EventProduct, Long> {

    List<EventProduct> findAllByEventOrderByCreateDate(Event event);


}
