package com.wthink.spit.dao;

import com.wthink.spit.pojo.Spit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface SpitDao extends MongoRepository<Spit,String> {

    public Page<Spit> findByParentid(String parentid, Pageable pageable);

}
