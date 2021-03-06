package com.wthink.tensquare_base.service;

import com.wthink.tensquare_base.dao.LabelDao;
import com.wthink.tensquare_base.pojo.Label;
import com.wthink.tensquare_common.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
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


    // Specification specification JPA中构建查询语句的结果集
    public List<Label> findSearch(Label label) {
        Specification specification =  createSeachStatement(label);
        return labelDao.findAll(specification);
    }
    /***
     * 构建查询语句
     * @param label
     * @return
     */
    private Specification createSeachStatement(Label label) {

        return new Specification() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder cb) {
                //and and and
                List<Predicate> predicateList = new ArrayList<>();
                //拼接构造语句     labelname like ?
                if(!StringUtils.isEmpty(label.getLabelname())){
                    predicateList.add(cb.like(root.get("labelname").as(String.class),"%"+label.getLabelname()+"%"));
                }
                if(!StringUtils.isEmpty(label.getState())){  //   state = ?
                    predicateList.add(cb.equal(root.get("state").as(String.class),label.getState()));
                }
                if(!StringUtils.isEmpty(label.getRecommend())){  //   state = ?
                    predicateList.add(cb.equal(root.get("recommend").as(String.class),label.getRecommend()));
                }
                return cb.and(predicateList.toArray(new Predicate[predicateList.size()]));
            }
        };
    }

    public Page<Label> findSearchPage(Label label, Integer page, Integer size) {

        Specification specification =  createSeachStatement(label);
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        return labelDao.findAll(specification,pageRequest);
    }
}
