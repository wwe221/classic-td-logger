package com.classic.td.logger.store.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "gold_history")
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class GoldHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "user_id", length = 40)
    private String userId;

    @Column(name = "flag")
    private boolean flag;

    @Column(name = "gold")
    private Integer gold;

    @Column(name = "time")
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime time;

}
