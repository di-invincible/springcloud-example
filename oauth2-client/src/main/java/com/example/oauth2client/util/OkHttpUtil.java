package com.example.oauth2client.util;

import okhttp3.*;

import java.io.IOException;

/**
 * @author aaron
 * @since 2020-12-28
 */

public class OkHttpUtil {

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public static String postSynchronized(String url,String content) throws IOException {
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = RequestBody.create(JSON, content);
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        Response response = client.newCall(request).execute();
        //response.body().string()这一句代码在方法体里面只能用一次(包括打印输出的使用)
        if(response.isSuccessful()){
            return response.body().string();
        }else{
            throw new IOException("Unexpected code " + response);
        }
    }

    public static String getSynchronized(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        Response response = client.newCall(request).execute();
        //response.body().string()这一句代码在方法体里面只能用一次(包括打印输出的使用)
        if(response.isSuccessful()){
            return response.body().string();
        }else{
            throw new IOException("Unexpected code " + response);
        }
    }


}
