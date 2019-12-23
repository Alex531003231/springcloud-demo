package com.lhb.hutoolexceldemo.exceldemo;

import cn.hutool.poi.excel.BigExcelWriter;
import cn.hutool.poi.excel.ExcelUtil;
import com.lhb.hutoolexceldemo.domain.Person;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Created By haibo.li01@hand-china.com
 * @time: 2019/12/6  17:26;
 * @description:
 */
public class ExcelDemoTest2 {

    @Test
    public void test1(){
        List<Person> personList=new ArrayList<>();
        Person person1 = new Person("aa",10, LocalDateTime.now());
        Person person2 = new Person("bb",11, LocalDateTime.now());
        Person person3 = new Person("cc",12, LocalDateTime.now());
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        exportExcel(personList);

    }

    private void exportExcel(List<Person> list) {
        String fileName= String.valueOf(System.currentTimeMillis());
        BigExcelWriter writer= ExcelUtil.getBigWriter("C:/Users/LHB/Desktop/acc/excel/"+fileName+".xlsx");
        //跳过第一行
//        writer.passCurrentRow();
        //设置标题，合并首行单元格
//        writer.merge(row.size()-1,"这是一个标题");
        // 一次性写出内容，使用默认样式
        writer.write(list);
        // 关闭writer，释放内存
        writer.close();
    }

}
