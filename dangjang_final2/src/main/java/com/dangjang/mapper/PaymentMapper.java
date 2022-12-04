package com.dangjang.mapper;

import com.dangjang.dto.PaymentMapperDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
@Mapper
public interface PaymentMapper {
    @Select("select * from payment where seq_order = #{orderNum}")
    PaymentMapperDTO getOrderPayment(String orderNum);

    @Select("select * from payment where seq_order = #{seq_order}")
    PaymentMapperDTO getPaymentDetail(Map<String, String> map);

    @Update("update payment set payment_status = '주문취소', update_date = now() where seq_order = #{seq_order}")
    void cancelOrder(Map<String, String> map);

    @Update("update payment set payment_status = '환불완료', update_date = now() where seq_order = #{seq_order}")
    void refundOrder(Map<String, String> map);
}
