package com.wthink.tensquare_common.entity;

import java.util.List;

/**
 * @描述:
 * @作者:wangshuai
 * @时间:2020/5/8 10:53
 */
public class PageResult<T> {
    private Long total;
    private List<T> rows;

    public PageResult(Long total, List<T> rows) {
        super();
        this.total = total;
        this.rows = rows;
    }
    // getter and setter ....
}
