package com.dangjang.repository;

import com.dangjang.domain.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface DeliveryRepository  extends JpaRepository<Delivery, Long> {

    @Query("select d from Delivery d where d.id = ?1 and d.deliveryStatus in ('배송중', '배송전')")
    boolean getDeliveryStatus(Long id);
}
