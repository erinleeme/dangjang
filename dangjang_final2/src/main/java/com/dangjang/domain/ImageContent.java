package com.dangjang.domain;

import com.dangjang.domain.type.ImageType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class ImageContent extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name="seq_image")
    private Long id;

    private String originalName; // 원래 파일명

    private String uploadName; // 서버에 저장될 파일명

    private String filePath;  // 파일경로(실제경로)

    @Enumerated(EnumType.STRING)
    private ImageType imageType;  // 말그대로 이미지가 활용될 장소.

    private Long imageTypeSeq; // 그 이미지 테이블의 고유 pk

    @Column(name = "image_count")
    private int count; // 순서



}
