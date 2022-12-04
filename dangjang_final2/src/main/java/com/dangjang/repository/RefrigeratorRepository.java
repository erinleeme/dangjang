package com.dangjang.repository;

import com.dangjang.domain.Refrigerator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface RefrigeratorRepository extends JpaRepository<Refrigerator, Long> {

    List<Refrigerator> findTop1ByOrderByIdDesc();

    // int getRefrigeratorCount(String memberId);
}
