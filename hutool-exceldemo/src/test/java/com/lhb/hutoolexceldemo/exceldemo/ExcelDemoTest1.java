package com.lhb.hutoolexceldemo.exceldemo;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.poi.excel.BigExcelWriter;
import cn.hutool.poi.excel.ExcelUtil;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Created By haibo.li01@hand-china.com
 * @time: 2019/12/6  9:48;
 * @description:
 */
public class ExcelDemoTest1 {

    @Test
    public void test1(){

        long startTimes = System.currentTimeMillis();
        List<List<?>> list=new ArrayList<>();
        List<?> row=null;
        for (int i = 0; i < 10; i++) {
            row = CollUtil.newArrayList("aa"+i, "bb"+i, "cc"+i, "dd"+i,"ee"+i,DateUtil.date(), i);
            list.add(row);
        }

        String fileName= String.valueOf(System.currentTimeMillis());
        BigExcelWriter writer= ExcelUtil.getBigWriter("C:/Users/LHB/Desktop/acc/excel/"+fileName+".xlsx");

        //跳过第一行
//        writer.passCurrentRow();
        //设置标题，合并首行单元格
        writer.merge(row.size()-1,"这是一个标题");
        // 一次性写出内容，使用默认样式
        writer.write(list);
        // 关闭writer，释放内存

        writer.close();
        long endTimes = System.currentTimeMillis();

        long runTimes=endTimes-startTimes;
        System.out.println("运行时间："+runTimes/1000+"s");
    }
}
