package com.dangjang.dto;

import com.dangjang.domain.type.RequestType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class FAQDTO {
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private Long id;
    private String content;
    private String reply;
    private RequestType requestType;
}
