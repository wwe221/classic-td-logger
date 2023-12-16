package com.classic.td.logger.sidecontent.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "cardpack_use_count")
@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class CardPackUseCount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "version")
    private Integer version;

    @Column(name = "flag")
    private boolean flag;

    @Column(name = "user_id", length = 40)
    private String userId;

    @Column(name = "nick_name", length = 40)
    private String nickName;

    @Column(name = "time")
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime time;

    @Column(name = "use_count")
    private Integer useCount;

    @Column(name = "cardindex0")
    private Integer cardIndex0;

    @Column(name = "cardindex1")
    private Integer cardIndex1;

    @Column(name = "cardindex2")
    private Integer cardIndex2;

    @Column(name = "cardindex3")
    private Integer cardIndex3;

    @Column(name = "cardindex4")
    private Integer cardIndex4;

}
