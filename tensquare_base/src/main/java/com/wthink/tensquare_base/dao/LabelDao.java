package com.wthink.tensquare_base.dao;

import com.wthink.tensquare_base.pojo.Label;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @描述:
 * JpaRepository提供了基本的增删改查
 * JpaSpecificationExecutor用于做复杂的条件查询
 * @作者:wangshuai
 * @时间:2020/5/8 11:25
 */
public interface LabelDao extends JpaRepository<Label, String>, JpaSpecificationExecutor<Label> {

    Label getById(String id);
}
