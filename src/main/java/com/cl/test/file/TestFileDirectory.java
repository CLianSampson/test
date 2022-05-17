package com.cl.test.file;

import cn.hutool.core.io.FileUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chen lian
 * @date 2021年12月06日 9:46
 */
public class TestFileDirectory {

//    public static void main(String[] args) {
//
//        String path = "C:\\Users\\606473\\Desktop\\首汽11月价格更新";
//        String updatePath = "C:\\Users\\606473\\Desktop\\首汽11月价格更新\\update.sql";
//
//        String template = "UPDATE appointment_order SET total_price = (SELECT round( sum( a ), 2 ) FROM (( SELECT sum( amount )* 0.9 AS a FROM `appointment_price_detail` WHERE order_id = '#replace#' AND NAME != '调度费' AND NAME != '高速服务费' AND NAME != '停车费' ) UNION ALL ( SELECT sum( amount ) AS a \tFROM `appointment_price_detail` WHERE order_id = '#replace#' AND ( NAME = '调度费' OR NAME = '高速服务费' OR NAME = '停车费' ) ) ) c ) WHERE order_id = '#replace#';";
//
//        List<File> files = FileUtil.loopFiles(path);
//        for (File file : files) {
//            String content = FileUtil.readString(file, StandardCharsets.UTF_8);
//            JSONObject jsonObject = JSONObject.parseObject(content);
//            JSONObject data = jsonObject.getJSONObject("data");
//            JSONArray rows = data.getJSONArray("rows");
//            System.out.println(rows);
//            for (Object row : rows) {
//                JSONArray array = (JSONArray) row;
//                String orderId = (String) array.get(0);
//                String sql = template.replace("#replace#",orderId) + "\n";
//                FileUtil.appendString(sql,updatePath,StandardCharsets.UTF_8);
//            }
//        }
//
//    }




    public static void main(String[] args) {
        String path = "C:\\Users\\606473\\Desktop\\bbbb.xls";

        readFilexls(path);
    }
    //xls文件
    public static void readFilexls(String filePath) {
        System.out.println("readFilexls获取文件路径:"+filePath);
        File f = new File(filePath);

        List<Map<String,Object>> list =new ArrayList<>();

        try {
            Workbook book = Workbook.getWorkbook(f);//
            Sheet sheet = book.getSheet(0); // 获得第一个工作表对象
            for (int i = 0; i < sheet.getRows(); i++) {
                if (i == 0) continue;

                Map<String,Object> map = new HashMap<>();
                Map<String,Object> deliveryInfo = new HashMap<>();
                Map<String,Object> pickUpInfo = new HashMap<>();

                for (int j = 0; j < sheet.getColumns(); j++) {
                    Cell cell = sheet.getCell(j, i); // 获得单元格
                    String content = cell.getContents();
                    //dataId
                    if (j == 0){
                        if (!StringUtils.isEmpty(content)) break;
                    }

                    //requestId
                    if (j == 1){
                        map.put("requestId",content);
                    }

                    //sendMobile
                    if (j == 2){
                        map.put("mobilePhone",content);
                    }

                    //寄件信息
                    if (j == 3){
                        deliveryInfo.put("address",content);
                    }

                    //收件信息
                    if (j == 4){
                        pickUpInfo.put("address",content);
                    }

                    //货好 时间
                    if (j == 5){
                        deliveryInfo.put("deliverTime",content);
                    }
                }

                map.put("deliveryInfo",deliveryInfo);
                map.put("pickUpInfo",pickUpInfo);

                list.add(map);

            }
        } catch (BiffException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        System.out.println(JSON.toJSONString(list));

        list.forEach(mapp ->{

        });
    }


}
