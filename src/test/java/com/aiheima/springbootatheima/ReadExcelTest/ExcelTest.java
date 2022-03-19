package com.aiheima.springbootatheima.ReadExcelTest;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
public class ExcelTest {
    @Test
    public void excelTest(){
        ExcelReader excelReader = ExcelUtil.getReader("C:\\Users\\chenj\\Desktop\\demo.xls");
        Object o = excelReader.readCellValue(0, 0);
        System.out.println(o);
    }
}
