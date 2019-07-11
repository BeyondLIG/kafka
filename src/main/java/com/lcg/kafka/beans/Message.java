package com.lcg.kafka.beans;

import lombok.Data;

import java.util.Date;

/**
 * @Author: licg
 * @Date: 2019/7/11
 * @Description：
 */

@Data
public class Message {
    private Long id;

    private String msg;

    private Date sendTime;
}