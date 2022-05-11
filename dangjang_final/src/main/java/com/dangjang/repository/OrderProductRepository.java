package com.dangjang.repository;

import com.dangjang.domain.OrderProduct;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {

    @Query("select o from OrderProduct o where o.order in (:ids)")
    List<OrderProduct> getOrderProductList(@Param("ids") List<Long> ids);
}
