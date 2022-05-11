package com.dangjang.dto;

import com.dangjang.domain.OneToOneRequest;
import com.dangjang.domain.type.OtOStatus;
import com.dangjang.domain.type.RequestType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.annotations.One;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@ToString
public class OneToOneRequestDTO {
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private Long id;
    private String title;
    private Long memberId;
    private OtOStatus otoStatus;
    private String content;
    private String replyContent;
    private LocalDateTime completeDate;
    private RequestType requestType;

    private int order_num; //주문번호 추가
    //private Long seq_image_content;

//    @Builder.Default
//    private List<ImageContentDTO> imageContentDTOList = new ArrayList<>();

    private String image1;
    private String image2;

}
