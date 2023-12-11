package com.rabbiter.oes.util;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import org.apache.poi.ss.usermodel.*;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author wangjingyuan
 * @date 2021/12/8
 */
public class ExcelUtil {
    /**
     * 导出
     * @param response
     * @param data
     * @param fileName
     * @param sheetName
     * @param clazz
     * @throws Exception
     */
    public static void writeExcel(HttpServletResponse response, List<? extends Object> data, String fileName, String sheetName, Class clazz) throws Exception {
        //表头样式
        WriteCellStyle headWriteCellStyle = new WriteCellStyle();
        //设置表头居中对齐
        headWriteCellStyle.setHorizontalAlignment(HorizontalAlignment.CENTER);
        //内容样式
        WriteCellStyle contentWriteCellStyle = new WriteCellStyle();
        //设置内容靠左对齐
        contentWriteCellStyle.setHorizontalAlignment(HorizontalAlignment.LEFT);
        HorizontalCellStyleStrategy horizontalCellStyleStrategy = new HorizontalCellStyleStrategy(headWriteCellStyle, contentWriteCellStyle);
        EasyExcel.write(getOutputStream(fileName, response), clazz).excelType(ExcelTypeEnum.XLSX).sheet(sheetName).registerWriteHandler(horizontalCellStyleStrategy).doWrite(data);
    }

    private static OutputStream getOutputStream(String fileName, HttpServletResponse response) throws Exception {
        fileName = URLEncoder.encode(fileName, "UTF-8");
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");
        return response.getOutputStream();
    }

    public static void simpleWrite(List<Map<String, Object>> mapList, HttpServletResponse response, String fileName) throws Exception {
        List<List<String>> head = new ArrayList<List<String>>();
        Map<String, Object> map = mapList.get(0);
        map.forEach((k, v) -> {
            List<String> head0 = new ArrayList<>();
            if (!Objects.equals(k,"CITYID") && !Objects.equals(k,"GDID") && !Objects.equals(k,"COUNTYID") && !Objects.equals(k,"GRIDID") && !Objects.equals(k,"ROW_ID")) {
                head0.add(k);
                head.add(head0);
            }
        });
        //表头样式
        WriteCellStyle headWriteCellStyle = new WriteCellStyle();
        //设置表头居中对齐
        headWriteCellStyle.setHorizontalAlignment(HorizontalAlignment.CENTER);
        //内容样式
        WriteCellStyle contentWriteCellStyle = new WriteCellStyle();
        //设置内容靠左对齐
        contentWriteCellStyle.setHorizontalAlignment(HorizontalAlignment.LEFT);
        HorizontalCellStyleStrategy horizontalCellStyleStrategy = new HorizontalCellStyleStrategy(headWriteCellStyle, contentWriteCellStyle);
        EasyExcel.write(getOutputStream(fileName, response)).head(head).sheet(fileName).
                registerWriteHandler(horizontalCellStyleStrategy).doWrite(dataLong(mapList));
    }

    private static List<List<Object>> dataLong(List<Map<String, Object>> mapList) {
        List<List<Object>> list = new ArrayList<>();
        for (int i = 0; i < mapList.size(); i++) {
            List<Object> body = new ArrayList<>();
            Map<String, Object> map = mapList.get(i);
            for (String s : map.keySet()) {
                if (!Objects.equals(s,"CITYID") && !Objects.equals(s,"GDID") && !Objects.equals(s,"COUNTYID") && !Objects.equals(s,"GRIDID") && !Objects.equals(s,"ROW_ID")) {
                    body.add(map.get(s));
                }
            }
            list.add(body);
        }
        return list;
    }
}
