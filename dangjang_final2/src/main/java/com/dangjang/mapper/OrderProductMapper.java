package com.dangjang.mapper;

import com.dangjang.dto.OrderProductDTO;
import com.dangjang.dto.OrderProductMapperDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface OrderProductMapper {

    void orderProductInsert(OrderProductMapperDTO orderProductMapperDTO);

    @Select("select * from order_product where seq_order = #{orderNum}")
    List<OrderProductMapperDTO> getOrderProductList(String orderNum);

    List<OrderProductDTO> getOrderReviewList(Map<String, Object> map);

    @Update("update order_product set review_check = 1 where seq_order_pdt = #{seq_order_pdt}")
    void changeReviewCheck(Map<String, String> map);

    List<OrderProductMapperDTO> getBuyProduct(long seq_order);
}
