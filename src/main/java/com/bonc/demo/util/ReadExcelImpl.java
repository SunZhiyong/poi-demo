/*
 * 文件名：ExcelUtil.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：zhiyong
 * 修改时间：2017年7月21日
 */

package com.bonc.demo.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.bonc.demo.entity.Student;

public class ReadExcelImpl
{
    /**
     * 读取excel中的数据
     */
    public List<Student> readExcel(MultipartFile file) {
        String path = file.getOriginalFilename();
        if (path != null && !path.equals("")) {
            String text = getText(path);
            if (text !=null && !text.equals("")) {
                if (text.equals("xls")) {
                    return readXls(path);
                } else if (text.equals("xlsx")) {
                    return readXlsx(path);
                }
            }
        }
        return new ArrayList<Student>();
    }
    
    
    /**
     * 读取后缀为xls的excel文件的数据
     * @param path
     * @return List<Student>
     * @see
     */
    private List<Student> readXls(String path) {
        HSSFWorkbook hssfWorkbook = null;
        try {
            InputStream  iStream = new FileInputStream(path);
            hssfWorkbook = new HSSFWorkbook(iStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        Student student = null;
        List<Student> list = new ArrayList<Student>();
        if (hssfWorkbook != null) {
            //Read the Sheet
            for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
                HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
                if (hssfSheet == null) {
                    continue;
                }
                //Read the Row
                for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                    HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                    if (hssfRow != null) {
                        student = new Student();
                        HSSFCell sno = hssfRow.getCell(0);
                        HSSFCell name = hssfRow.getCell(1);
                        HSSFCell age = hssfRow.getCell(2);
                        HSSFCell score = hssfRow.getCell(3);
                        student.setSno(getValue(sno));
                        student.setName(getValue(name));
                        student.setAge(getValue(age));
                        student.setScore(Float.valueOf(getValue(score)));
                        list.add(student);
                        
                    }
                }
            }
            
        }
        return list;
    }
    
    private List<Student> readXlsx(String path) {
        XSSFWorkbook xssfWorkbook = null;
        try {
            InputStream  iStream = new FileInputStream(path);
            xssfWorkbook = new XSSFWorkbook(iStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        Student student = null;
        List<Student> list = new ArrayList<Student>();
        if (xssfWorkbook != null) {
            //Read the Sheet
            for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
                XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
                if (xssfSheet == null) {
                    continue;
                }
                //Read the Row
                for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
                    XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                    if (xssfRow != null) {
                        student = new Student();
                        XSSFCell sno = xssfRow.getCell(0);
                        XSSFCell name = xssfRow.getCell(1);
                        XSSFCell age = xssfRow.getCell(2);
                        XSSFCell score = xssfRow.getCell(3);
                        student.setSno(getValue(sno));
                        student.setName(getValue(name));
                        student.setAge(getValue(age));
                        student.setScore(Float.valueOf(getValue(score)));
                        list.add(student);
                        
                    }
                }
            }
            
        }
        return list;
    }
    
    /**
     * 获取文件拓展名
     * @param path
     * @return String
     * @see 1.0
     */
    private String getText(String path){
        if (path == null || path.equals("") || !path.contains(".")){
            return null;
        } else {
            return path.substring(path.lastIndexOf(".") + 1,path.length());
        }
    }
    
    /**
     * 
     * 判断后缀为xlsx的excel文件的数据类型
     * @param xssfCell
     * @return String
     * @see
     */
    @SuppressWarnings("static-access")
    private String getValue(XSSFCell xssfCell) {
        if (xssfCell.getCellType() == xssfCell.CELL_TYPE_BOOLEAN) {
            return String.valueOf(xssfCell.getBooleanCellValue());
        } else if (xssfCell.getCellType() == xssfCell.CELL_TYPE_NUMERIC) {
            return String.valueOf(xssfCell.getNumericCellValue());
        } else {
            return String.valueOf(xssfCell.getStringCellValue());
        }
    }
    
    /**
     * 
     * 判断后缀为xls的excel文件的数据类型
     * @param hssfCell
     * @return String
     * @see
     */
    @SuppressWarnings("static-access")
    private String getValue(HSSFCell hssfCell) {
        if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
            return String.valueOf(hssfCell.getBooleanCellValue());
        } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
            return String.valueOf(hssfCell.getNumericCellValue());
        } else {
            return String.valueOf(hssfCell.getStringCellValue());
        }
    }
}
