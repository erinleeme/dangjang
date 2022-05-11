package com.dangjang.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Favorite {
    @Id
    @GeneratedValue
    @Column(name = "seq_favorite")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    private Long productId;
    @CreatedDate
    private LocalDateTime createDate;


}
