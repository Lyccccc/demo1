package net.coderchen.demo1.demo;

import net.coderchen.demo1.util.HttpsUtil;

import java.util.List;

/**
 * @Author Liuyuchen
 * @Date 2018/08/23
 * @Description
 */
public class WxTuwenTest {
    public static void main(String[] args) {
        String url = "https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=";
        String accessToken = "13_2afjg2TLrxYlThfm9dF5WHJ9WsLyOU0bTvnylR05oL7hnkGzMOq4i6lmBfxV70FH-eI5w7eULI0RpW7miemP5KDXukCmRD8mC-FFS7y4vSfHjZ33F5C_iw0tLSYGGYjAFAQQI";
        String request = "{\"type\":\"news\",\"offset\":\"0\",\"count\":\"10\"}";
//        String response = HttpsUtil.httpGet("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx7e900bf7a0798d64&secret=546bc2ca5c41a223e951101fdb376a3d");
//        System.out.println(response);
        String responseStr = HttpsUtil.httpPost(url + accessToken, request);
    }
}
