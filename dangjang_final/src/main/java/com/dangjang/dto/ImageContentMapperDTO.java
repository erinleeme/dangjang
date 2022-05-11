package com.dangjang.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageContentMapperDTO {
    private long seq_image;
    private String file_path;
    private int image_type;
    private long image_type_seq;
    private String original_name;
    private String upload_name;
    private int image_count;
    private LocalDateTime create_date;
    private LocalDateTime update_date;
}
