package com.mh.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * 银行卡表(Card)实体类
 *
 * @author makejava
 * @since 2022-10-21 14:23:52
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Card {

    /**
     * 卡号
     */
    private Integer cid;
    /**
     * 卡类型：金卡、银卡、钻石卡...
     */
    private String type;
    /**
     * 余额
     */
    private Double account;
    /**
     * 开卡时间
     */
    private Date createTime;
    /**
     * 用户id
     */
    private Integer uid;
    /**
     * 卡号对应的用户
     */
    private User user;

    public void setUser(User user) {
        this.user = user;
    }

}

