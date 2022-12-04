package com.dangjang.repository;

import com.dangjang.domain.FAQ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FAQRepository extends JpaRepository<FAQ, Long> {

    List<FAQ> findTop4ByOrderByCreateDateDesc();

}
