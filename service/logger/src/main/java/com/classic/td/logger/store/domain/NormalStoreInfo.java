package com.classic.td.logger.store.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ingame_store_buy_info")
@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class NormalStoreInfo {
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

    @Column(name = "item_name", length = 50)
    private String itemName;

    @Column(name = "item_index")
    private Integer itemIndex;

    @Column(name = "before_gold")
    private Integer beforeGold;

    @Column(name = "use_gold")
    private Integer useGold;

    @Column(name = "left_gold")
    private Integer leftGold;

    @Lob
    @Column(name = "buyed_info")
    private String buyedInfo;

    @Column(name = "param0")
    private String param0;

    @Column(name = "param1")
    private String param1;

    @Column(name = "param2")
    private String param2;

    @Column(name = "param3")
    private String param3;

    @Column(name = "time")
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime time;

}
