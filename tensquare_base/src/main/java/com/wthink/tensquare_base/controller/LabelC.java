package com.wthink.tensquare_base.controller;

import com.wthink.tensquare_base.pojo.Label;
import com.wthink.tensquare_base.service.LabelService;
import com.wthink.tensquare_common.entity.Result;
import com.wthink.tensquare_common.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @描述:
 * @作者:wangshuai
 * @时间:2020/5/8 11:35
 */
@RestController
@RequestMapping("/label")
@CrossOrigin //解决跨域问题
public class LabelC {
    @Autowired
    private LabelService labelService;

    /**
     * 根据id查询详情
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable("id") String id){
        Label labelServiceById = labelService.getById(id);
        return new Result(true, StatusCode.OK,"查询成功！",labelServiceById);
    }

    /**
     * 根据id修改
     * @param id
     * @return
     */
    @PutMapping("/{id}")
    public Result updateById(@RequestBody Label label,@PathVariable("id") String id){
        label.setId(id);
        labelService.updateById(label);
        return new Result(true, StatusCode.OK,"修改成功！");
    }


    /**
     * 查询全部标签
     *
     * @return
     */
    @GetMapping
    public Result queryAllLabelList(){
        List<Label> labels = labelService.queryAllLabelList();

        return new Result(true,StatusCode.OK,"查询成功！",labels);
    }

    /**
     * 增加标签
     */
    @PostMapping
    public Result addLabel(@RequestBody Label label){
        labelService.addLabel(label);
        return new Result(true, StatusCode.OK,"添加成功！");
    }


    /**
     * 删除（通过id删除数据）
     */
    @DeleteMapping("/{id}")
    public  Result deleteById(@PathVariable("id") String id){
        labelService.deleteById(id);
        return new Result(true, StatusCode.OK,"删除成功！");
    }
}
