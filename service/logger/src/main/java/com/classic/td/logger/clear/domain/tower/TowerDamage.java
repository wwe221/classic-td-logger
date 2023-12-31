package com.classic.td.logger.clear.domain.tower;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tower_damage")
@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class TowerDamage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "version")
    private Integer version;

    @Column(name = "flag")
    private boolean flag;

    @Column(name = "tower_index")
    private Integer towerIndex;

    @Column(name = "boss_damage")
    private Long bossDamage;

    @Column(name = "normal_damage")
    private Long normalDamage;

    @Column(name = "difficult")
    private Integer difficult;

    @Column(name = "time")
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime time = LocalDateTime.now();
}
