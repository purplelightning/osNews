package com.example.wind.osnews.robot;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by wind on 17-7-21.
 */

public class HttpUtils {
    private static final String URL = "http://www.tuling123.com/openapi/api";
    private static final String API_KEY = "1b29a0b1c6d646059eeef992f45d8760";

    //发送一个消息,得到返回的消息,以robotresultbean格式返回
    public static ChatMessage sendMessage(String msg) {
        ChatMessage chatMessage = new ChatMessage();

        String jsonRes = doGet(msg);
        Gson gson = new Gson();
        RobotResultBean result = null;
        try {
            result = gson.fromJson(jsonRes, RobotResultBean.class);
            chatMessage.setMsg(result.getText());

        } catch (Exception e) {
            chatMessage.setMsg("服务器繁忙,请稍后再试");
        }
        chatMessage.setDate(new Date());
        chatMessage.setType(ChatMessage.Type.INCOMING);

        return chatMessage;
    }

    public static String doGet(String msg) {

        String result = "";
        String url = setParams(msg);
//        InputStream is = null;
//        ByteArrayOutputStream baos = null;
//        try {
//            URL urlNet = new URL(url);
//            HttpURLConnection conn = (HttpURLConnection) urlNet.openConnection();
//            conn.setRequestMethod("GET");
//            conn.setReadTimeout(5000);
//            conn.setConnectTimeout(5000);
//
//
//            is = conn.getInputStream();
////            int len = -1;
//            byte[] buf = new byte[1024];
//            baos = new ByteArrayOutputStream();
//
////            while ((len = is.read(buf)) != -1) {
////                baos.write(buf, 0, len);
////            }
//            baos.flush();
//            result = new String(baos.toByteArray());
//
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (baos != null)
//                try {
//                    baos.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            try {
//                if (is != null) {
//                    is.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        return result;
        OkHttpClient client=new OkHttpClient();
        Request request=new Request.Builder().url(url).build();
        Response response=null;
        try{
            response=client.newCall(request).execute();
            result=response.body().string();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static String setParams(String msg) {

        String url = "";
        try {
            url = URL + "?key=" + API_KEY + "&info=" +
                    URLEncoder.encode(msg, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return url;
    }


}







