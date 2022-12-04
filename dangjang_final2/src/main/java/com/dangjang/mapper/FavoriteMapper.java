package com.dangjang.mapper;

import com.dangjang.dto.FavoriteMapperDTO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface FavoriteMapper {

    int getUserFavoriteTotalCount(long memId); // 로그인시 해당유저의 찜 상품 총 수량

    // mypage
    @Select("select count(*) from favorite where seq_member = #{memberId}")
    int getFavoriteCount(String memberId);

    // mypage
    List<FavoriteMapperDTO> getFavoriteList(Map<String, Object> map);

    // mypage
    @Delete("delete from favorite where seq_favorite = #{favoriteId}")
    void deleteFavorite(String favoriteId);

    @Insert("insert into favorite(create_date, product_id, seq_member) values(now(), ${seq_product}, ${memId})")
    void productDetailPick(@Param("seq_product") String seq_product, @Param("memId") long memId);
}
