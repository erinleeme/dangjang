package com.dangjang.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FavoriteMapperDTO {
    private long seq_favorite;
    private long seq_member;
    private long product_id;
    private LocalDateTime create_date;

}
