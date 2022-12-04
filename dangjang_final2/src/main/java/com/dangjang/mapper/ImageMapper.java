package com.dangjang.mapper;

import com.dangjang.domain.BasicProduct;
import com.dangjang.dto.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ImageMapper {

    List<BasicProductMapperDTO> getImageCode(List<ProductMapperDTO> ids); // basic product 에 씨리얼 넘버만

    @Select("select * from basic_product where seq_basic_product = #{seq_basic_product}")
    BasicProductMapperDTO getOneImage(ProductMapperDTO productMapperDTO);

    void registerImage(ImageContentDTO imageContentDTO);
}
