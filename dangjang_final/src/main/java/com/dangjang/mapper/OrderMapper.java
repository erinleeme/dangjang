package com.dangjang.mapper;

import com.dangjang.dto.OrderClaimMapperDTO;
import com.dangjang.dto.OrderListMapperDTO;
import com.dangjang.dto.OrdersMapperDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface OrderMapper {

    @Select("select seq_order from orders order by seq_order desc limit 1")
    OrdersMapperDTO getLastOrderNum(); // 마지막 주문번호 가져오기

    void orderInformationInsert(OrdersMapperDTO ordersMapperDTO);

    List<OrdersMapperDTO> getOrderList(Map<String, Object> map);

    @Select("select count(*) from orders where seq_member = #{memberId}")
    int getOrderCount(String memberId);

    //배송 완료가 아닌 주문/배송 건수
    @Select("select count(*) from orders where seq_member = #{memberId} and order_status != '배송완료';")
    int orderCount(String memberId);

    List<OrderClaimMapperDTO> getOrderClaimList(Map<String, Object> map);

    List<OrderListMapperDTO> getOrderListMapper(Map<String, Object> map);

    @Select("select count(*) from order_product where seq_order = #{seq_order}")
    String getOrderItemCount(String seq_order);

    int getOrderClaimCount(String memberId);

    @Select("select * from orders where seq_order = #{seq_order}")
    OrdersMapperDTO getOrderDetail(Map<String, String> map);

    @Select("select order_num from orders where seq_order = #{seq_order} ")
    String getOrderNum(Map<String, String> map);

    @Update("update orders set pay_status = '주문취소' where seq_order = #{seq_order}")
    void cancelOrder(Map<String, String> map);

    @Update("update orders set pay_status = '환불완료' where seq_order = #{seq_order}")
    void refundOrder(Map<String, String> map);

    @Select("select count(*) from orders")
    long getOrderTotalCount();

    OrdersMapperDTO getOrderNumnDate(long memId);
}
