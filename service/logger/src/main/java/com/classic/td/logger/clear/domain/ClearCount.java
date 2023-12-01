package com.classic.td.logger.clear.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "clear_count")
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ClearCount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "user_id", length = 40)
    private String userId;

    @Column(name = "flag")
    private boolean flag;

    @Column(name = "count")
    private Integer count;

    @Column(name = "time")
    private LocalDateTime time;
}
