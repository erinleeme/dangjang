package com.dangjang.mapper;

import com.dangjang.dto.DeliveryMapperDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
@Repository
public interface DeliveryMapper {

    void deliveryInsert(DeliveryMapperDTO deliveryMapperDTO);

    @Select("select seq_delivery from delivery order by seq_delivery desc limit 1")
    String getSeq_delivery();

    long getMemberdeliverySeq(String phone);

    // mypage
    @Select("select * from delivery where seq_delivery = #{deliveryNum}")
    DeliveryMapperDTO getOrderDelivery(String deliveryNum);

    // mypage
    @Select("select * from delivery where seq_delivery in(select seq_delivery from orders where seq_order = #{seq_order})")
    DeliveryMapperDTO getOrderDeliveryDetail(Map<String, String> map);
}
