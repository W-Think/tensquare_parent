package com.wthink.tensquare_base.service;

import com.wthink.tensquare_base.dao.LabelDao;
import com.wthink.tensquare_base.pojo.Label;
import com.wthink.tensquare_common.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @描述:
 * @作者:wangshuai
 * @时间:2020/5/8 11:36
 */
@Service
public class LabelService {
    @Autowired
    private LabelDao labelDao;
    @Autowired
    IdWorker idWorker;

    public Label getById(String id) {
        return labelDao.getById(id);
    }

    @Modifying
    @Transactional
    public void addLabel(Label label) {
        label.setId(idWorker.nextId()+"");
        labelDao.save(label);
    }

    public List<Label> queryAllLabelList() {
        return labelDao.findAll();
    }

    @Modifying
    @Transactional
    public Label updateById(Label label) {
        //save 判断如果id不存在，则新增， 如果id存在，则修改
        return labelDao.save(label);
    }

    @Modifying
    public void deleteById(String id) {
        labelDao.deleteById(id);
    }
}