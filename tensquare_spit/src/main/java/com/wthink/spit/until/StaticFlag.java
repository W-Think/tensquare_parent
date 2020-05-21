package com.wthink.spit.until;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.poi.excel.ExcelWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @描述:
 * @作者:wangshuai
 * @时间:2020/4/22 19:42
 */
public class StaticFlag {
    /***session 用户的key**/
    public static  final  String USERINFO="userinfo";

    /**
     * 设置uuid
     * @return
     */
    public static String queryUUID() {
        return RandomUtil.randomUUID().replace("-","");
    }

    /**
     * 导入导出
     * @param response
     * @param writer
     */
    public   static void excelExportUtils(HttpServletResponse response, ExcelWriter writer) {
        //out为OutputStream，需要写出到的目标流

        //response为HttpServletResponse对象
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        //test.xls是弹出下载对话框的文件名，不能为中文，中文请自行编码
        response.setHeader("Content-Disposition","attachment;filename="+ DateUtil.format(new Date(),"yyyyMMddHHmmss") +".xls");

        ServletOutputStream out= null;
        try {
            out = response.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        writer.flush(out, true);
        // 关闭writer，释放内存
        writer.close();
        //此处记得关闭输出Servlet流
        IoUtil.close(out);
    }

    /**
     * 图片上传
     * @param file 上传的文件
     * @param filePath 文件地址
     * @return
     */
//    public static String upload(MultipartFile file, String filePath){
//        //获取上传文件的名
//        String filename = file.getOriginalFilename();
//        //定义上传图片保存路径
//        String path = filePath+"rotPhoto";
//        //如果不存在则新建上传文件路径
//        File filepath = new File(path, filename);
//        if (!filepath.getParentFile().exists()){
//            filepath.getParentFile().mkdirs();
//        }
//        //写入文件到指定目录  File.separator == /
//        try {
//            file.transferTo(new File(path+File.separator+filename));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        //将保存的文件的地址响应给html页面
//        return "/images/rotPhoto/"+filename;
//    }
}
