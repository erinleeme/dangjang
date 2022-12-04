package com.dangjang.repository;

import com.dangjang.domain.BigCategory;
import com.dangjang.domain.MiddleCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MiddleCategoryRepository extends JpaRepository<MiddleCategory, Long> {
    // 특정 big category 선택해 middle category  view 정렬
    @Query("select m from MiddleCategory m where m.bigCategory = ?1")
    List<MiddleCategory> findByBigCategory(BigCategory bigCategory);

}
