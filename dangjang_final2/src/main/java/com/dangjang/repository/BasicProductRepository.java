package com.dangjang.repository;

import com.dangjang.domain.BasicProduct;
import com.dangjang.domain.MiddleCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface BasicProductRepository extends JpaRepository<BasicProduct, Long> {

    @Query("select b from BasicProduct b where b.smallCategory = ?1 order by b.receiveDate")
    List<BasicProduct> findAllBySmallCategoryOrderByReceiveDate(MiddleCategory middleCategory);

}
