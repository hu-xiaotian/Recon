package com.baidu.ocr;

import com.baidu.ai.aip.utils.Base64Util;
import com.baidu.ai.aip.utils.FileUtil;
import com.baidu.ai.aip.utils.HttpUtil;

import java.net.URLEncoder;


public class App 
{
    public static void main(String[] args) throws Exception
    {
        //模板ID为：70ee241c35df98a6398939023cd45f4d
        // iocr识别apiUrl
        String recogniseUrl = "https://aip.baidubce.com/rest/2.0/solution/v1/iocr/recognise";


        String filePath = "E:\\renrenopen\\baidu\\test1.png";
        try {
                byte[] imgData = FileUtil.readFileByBytes(filePath);
                String imgStr = Base64Util.encode(imgData);
                // 请求模板参数
                String recogniseParams = "templateSign=70ee241c35df98a6398939023cd45f4d&image=" + URLEncoder.encode(imgStr, "UTF-8");
                // 请求分类器参数
                String classifierParams = "classifierId=your_classfier_id&image=" + URLEncoder.encode(imgStr, "UTF-8");
                
                
                String accessToken = com.baidu.ai.aip.auth.AuthService.getAuth();
                // 请求模板识别
                String result = HttpUtil.post(recogniseUrl, accessToken, recogniseParams);
                // 请求分类器识别
                // String result = HttpUtil.post(recogniseUrl, accessToken, classifierParams);
                
                System.out.println(result);
        } catch (Exception e) {
                e.printStackTrace();
        }
    }
}