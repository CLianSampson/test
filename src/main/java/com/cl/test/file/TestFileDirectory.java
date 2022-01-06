package com.cl.test.file;

import cn.hutool.core.io.FileUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author chen lian
 * @date 2021年12月06日 9:46
 */
public class TestFileDirectory {

    public static void main(String[] args) {
        
        String path = "C:\\Users\\606473\\Desktop\\首汽11月价格更新";
        String updatePath = "C:\\Users\\606473\\Desktop\\首汽11月价格更新\\update.sql";

        String template = "UPDATE appointment_order SET total_price = (SELECT round( sum( a ), 2 ) FROM (( SELECT sum( amount )* 0.9 AS a FROM `appointment_price_detail` WHERE order_id = '#replace#' AND NAME != '调度费' AND NAME != '高速服务费' AND NAME != '停车费' ) UNION ALL ( SELECT sum( amount ) AS a \tFROM `appointment_price_detail` WHERE order_id = '#replace#' AND ( NAME = '调度费' OR NAME = '高速服务费' OR NAME = '停车费' ) ) ) c ) WHERE order_id = '#replace#';";

        List<File> files = FileUtil.loopFiles(path);
        for (File file : files) {
            String content = FileUtil.readString(file, StandardCharsets.UTF_8);
            JSONObject jsonObject = JSONObject.parseObject(content);
            JSONObject data = jsonObject.getJSONObject("data");
            JSONArray rows = data.getJSONArray("rows");
            System.out.println(rows);
            for (Object row : rows) {
                JSONArray array = (JSONArray) row;
                String orderId = (String) array.get(0);
                String sql = template.replace("#replace#",orderId) + "\n";
                FileUtil.appendString(sql,updatePath,StandardCharsets.UTF_8);
            }
        }

    }

}
