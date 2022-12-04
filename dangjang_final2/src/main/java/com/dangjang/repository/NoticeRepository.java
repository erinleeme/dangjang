package com.dangjang.repository;

import com.dangjang.domain.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface NoticeRepository extends JpaRepository<Notice, Long> {

    List<Notice> findTop4ByOrderByCreateDateDesc();
    @Query("select n from Notice n order by n.createDate desc ")
    List<Notice> noticeList();
}
