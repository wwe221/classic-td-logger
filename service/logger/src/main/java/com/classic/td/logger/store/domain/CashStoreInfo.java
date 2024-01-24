package com.classic.td.logger.store.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "cash_store_buy_info")
@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class CashStoreInfo {

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

    @Column(name = "store_type")
    private Integer storeType;

    @Column(name = "product_id", length = 50)
    private String productId;

    @Column(name = "purchase_id")
    private String purchaseId;

    @Column(name = "price")
    private Integer price;

    @Column(name = "cash_item_name", length = 50)
    private String cashItemName;

    @Column(name = "cash_itemid", length = 50)
    private String cashItemid;

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

    @Column(name = "platform_type")
    private Integer platformType;
}
