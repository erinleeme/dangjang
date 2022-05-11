package com.dangjang.mapper;

import com.dangjang.dto.MemberMapperDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface WithDrawalMapper {
    void withdrawalSave(MemberMapperDTO memberMapperDTO);
}
