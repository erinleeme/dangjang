package com.dangjang.dto;

import com.dangjang.domain.type.TopDisplayOn;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.tomcat.jni.Local;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class NoticeMapperDTO {
    private Long seq_notice;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDateTime create_date;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDateTime update_date;
    private String content;
    private String title;
    private String top_display_on;
    private String writer;
}
