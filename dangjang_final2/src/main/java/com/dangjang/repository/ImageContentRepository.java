package com.dangjang.repository;

import com.dangjang.domain.ImageContent;
import com.dangjang.domain.type.ImageType;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ImageContentRepository extends JpaRepository<ImageContent, Long> {
    List<ImageContent> findAllByImageTypeAndAndImageTypeSeqOrderByCount(ImageType imageType, Long imageSeq);

//    @Query("select i from ImageContent i where i.imageType = ?1 and i.imageTypeSeq in (:ids)")
//    List<ImageContent> getProductImage(String 상품, @Param("ids") List<Long> ids);
}
