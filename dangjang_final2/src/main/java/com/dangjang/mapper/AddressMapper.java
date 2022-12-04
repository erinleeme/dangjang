package com.dangjang.mapper;

import com.dangjang.dto.AddressMapperDTO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface AddressMapper {
    @Select("select * from address where seq_member = #{memberId} order by field(base_status, 1) desc, create_date desc")
    List<AddressMapperDTO> addressListByMember(String memberId);

    void addAddress(Map<String, String> map);

    //기본 배송지를 non_base로 만듦
    @Update("update address set base_status = 0 where seq_address = #{seq_address}")
    void updateBaseToNon(Long seq_address);

    //기본 배송지 정보
    @Select("select * from address where base_status = 1")
    AddressMapperDTO getBaseAdr();

    @Delete("delete from address where seq_address = #{addressId}")
    void deleteAddress(String addressId);

    void updateAddress(Map<String, String> map);

    void addressAdd(Map<String, String> map);

    @Select("select base_status from address where seq_member = #{seq_member} order by base_status desc limit 1")
    String getLatelyBaseStatus(String seq_member);

    AddressMapperDTO getAddressOne(Object baseStatusNum);

    @Select("select * from address where seq_member= #{seq_member} and base_status = #{baseStatus}")
    AddressMapperDTO getOrderAddress(@Param("seq_member") String seq_member, @Param("baseStatus") String baseStatus);
}
