package com.example.userservice.util;

import okhttp3.*;

import java.io.IOException;

/**
 * @author aaron
 * @since 2020-12-28
 */

public class OkHttpUtil {

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");


    public static void getAsynchronous() {
        String url = "http://api.k780.com/?app=weather.history";
        okhttp3.Request request = new okhttp3.Request.Builder().url(url).get().build();
        OkHttpClient okHttpClient = new OkHttpClient();
        final Call call = okHttpClient.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("Fail");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                System.out.println(response.body().string());

            }
        });
    }

    public static void postAsynchronous(String url, String content) {
        RequestBody requestBody = RequestBody.create(JSON, content);
        okhttp3.Request request = new okhttp3.Request.Builder().url(url).post(requestBody).build();
        OkHttpClient okHttpClient = new OkHttpClient();
        final Call call = okHttpClient.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("Fail");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                System.out.println(response.body().string());

            }
        });
    }

    public static String postSynchronized(String url, String content) throws IOException {
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = RequestBody.create(JSON, content);
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        Response response = client.newCall(request).execute();
        //response.body().string()这一句代码在方法体里面只能用一次(包括打印输出的使用)
        if (response.isSuccessful()) {
            return response.body().string();
        } else {
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
        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }


}
