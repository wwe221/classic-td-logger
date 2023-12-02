package com.classic.td.logger.clear.domain.tower;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tower_create_count")
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class TowerCount {
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

    @Column(name = "create_count")
    private Integer createCount;

}
