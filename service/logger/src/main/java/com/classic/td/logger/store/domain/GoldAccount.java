package com.classic.td.logger.store.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "gold_table")
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class GoldAccount {
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
    private LocalDateTime time;

}
