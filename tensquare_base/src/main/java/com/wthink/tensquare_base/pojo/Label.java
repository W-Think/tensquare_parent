package com.wthink.tensquare_base.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @描述:
 * @作者:wangshuai
 * @时间:2020/5/8 11:20
 */
@Entity
@Table(name = "tb_label")
@Data
public class Label {
    @Id
    private String id;//
    private String labelname;// 标签名称
    private String state;// 状态
    private Long count;// 使用数量
    private Long fans;// 关注数
    private String recommend;// 是否推荐
}