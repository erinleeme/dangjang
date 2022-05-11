package com.dangjang.dto;

import com.dangjang.domain.type.ImageType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;


@Getter
@Setter
@ToString
public class ImageContentDTO {
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private Long id;
    private String originalName;
    private String uploadName;
    private String filePath;
    private ImageType imageType;
    private Long imageTypeSeq;
    private int count;
}
