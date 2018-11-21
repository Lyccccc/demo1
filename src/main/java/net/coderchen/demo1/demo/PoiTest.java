package net.coderchen.demo1.demo;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

/**
 * excel文档测试类
 * Created by Liuyuchen on 2018/01/29.
 */
public class PoiTest {
    public static void main(String[] args) throws IOException {
        File file = new File("G:\\test\\test.xls");
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(new FileInputStream(file));
        System.out.println(hssfWorkbook);
        Iterator<Sheet> sheetIterator = hssfWorkbook.iterator();
        while(sheetIterator.hasNext()){
            Sheet sheet = sheetIterator.next();
//            System.out.println(sheet);
            Iterator<Row> rowIterator = sheet.iterator();
            while(rowIterator.hasNext()){
                Row row = rowIterator.next();
//                System.out.println(row);
                Iterator<Cell> cellIterator = row.iterator();
                while(cellIterator.hasNext()){
                    Cell cell = cellIterator.next();
                    System.out.print(cell);
                    System.out.print(" ");
                }
                System.out.println();
            }

        }

    }
}
