package com.dangjang.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;


@Getter
@Setter
@ToString
public class FavoriteDTO {
    private Long id;
    private Long memberMemberId;
    private Long productId;
    private LocalDateTime createDate;
}
