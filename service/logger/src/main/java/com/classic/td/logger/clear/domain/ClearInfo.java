package com.classic.td.logger.clear.domain;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "CLEAR_INFO")
@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ClearInfo {
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
    private Long utcTime;

    @Column(name = "nick_name", length = 40)
    private String nickName;

    @Column(name = "road_type")
    private Integer roadType;

    @Column(name = "mode_type")
    private Integer modeType;

    @Column(name = "difficult")
    private Integer difficult;

    @Column(name = "point")
    private Long point;

    @Column(name = "total_ingame_gold")
    private Integer totalIngameGold;

    @Column(name = "tower_data")
    private String towerData;

    @Column(name = "week")
    private Integer week;

    @Column(name = "day")
    private Integer day;

    @Column(name = "time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime time;

    public String getCreatedDateTime() {
        if (time != null)
            return time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        else return "";
    }

}
