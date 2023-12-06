package com.classic.td.logger.sidecontent.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "mine_upgrade")
@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class MineUpgrade {
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

    @Column(name = "utc")
    private Long utc;

    @Column(name = "nick_name", length = 40)
    private String nickName;

    @Column(name = "time")
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime time;

    @Column(name = "mineral_index")
    private Integer mineralIndex;

    @Column(name = "before_level")
    private Integer beforeLevel;

    @Column(name = "after_level")
    private Integer afterLevel;

    @Column(name = "mineral_data")
    private String mineralData;
}
