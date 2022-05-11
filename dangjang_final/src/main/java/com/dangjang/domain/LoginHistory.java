package com.dangjang.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)

public class LoginHistory {
    @Id
    @GeneratedValue
    @Column(name = "seq_log_history")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @CreatedDate
    private LocalDateTime loginDate;

    private LocalDateTime logoutDate;

//    private String ip;
     // lcoalhost8909/
}
