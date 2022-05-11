package com.dangjang.mapper;

import com.dangjang.dto.OneToOneRequestDTO;
import com.dangjang.dto.OneToOneRequestMapperDTO;
import com.dangjang.dto.OneToOneRequestMapperSDTO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface OneToOneMapper {
    List<OneToOneRequestMapperSDTO> getOneToOneList(Map<String, Object> map);

    @Select("select count(*) from one_to_one_request where seq_member = #{memberId}")
    int getOneToOneCount(String memberId);

    void updateOto(Map<String, String> map);

    void registerOto(Map<String, String> map);

    OneToOneRequestDTO getLimitOne(String memberId);

    @Delete("delete from one_to_one_request where seq_oto_req = #{otoId}")
    void deleteOto(Map<String, String> map);

    @Select("select * from one_to_one_request where seq_oto_req = #{otoId}")
    OneToOneRequestMapperDTO checkReplyOto(Map<String, String> map);
}
