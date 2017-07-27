/*
 * 文件名：ExcelController.java
 * 版权：Copyright by www.bonc.com.cn
 * 描述：
 * 修改人：zhiyong
 * 修改时间：2017年7月21日
 */

package com.bonc.demo;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.bonc.demo.util.JsonResult;
import com.bonc.demo.util.POIUtil;

@Controller
public class ExcelController
{
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult upload (@RequestParam("excelfile") MultipartFile excelfile) {
        List<String[]> list = null;
        try
        {
            list = POIUtil.readExcel(excelfile);
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return new JsonResult(list);
    }
    
    @RequestMapping("/index")
    public String index(){
        return "readExcel.html";
    }
}
