package com.classic.td.logger.sidecontent.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "cardpack_destroy")
@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class CardPackDestroy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "version")
    private Integer version;

    @Column(name = "flag")
    private Integer flag;

    @Column(name = "user_id", length = 40)
    private String userId;

    @Column(name = "towerIndex")
    private Integer towerIndex;

    @Column(name = "beforeCount")
    private Integer beforeCount;

    @Column(name = "afterCount")
    private Integer afterCount;

    @Column(name = "time")
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime time;

}

