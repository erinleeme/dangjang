package com.dangjang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LoginHistoryMapper {

    void loginLog(Long memId);

    Long getLoginLog(Long memId);

    void logoutLog(Long id);
}
