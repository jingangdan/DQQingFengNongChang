package com.dq.qingfengnc.utils;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

/**
 * 检查本地更新
 *
 * @author harvic
 * @date 2014-5-7
 * @address http://blog.csdn.net/harvic880925
 *
 * 借鉴
 */
public class VersionCodeUtils {
    //public static final String SERVER_IP="http://192.168.1.105/";
    public static final String SERVER_IP = "http://115.28.233.86";
    public static final String SERVER_ADDRESS=SERVER_IP+"try_downloadFile_progress_server/index.php";//软件更新包地址
    public static final String UPDATESOFTADDRESS=SERVER_IP+"try_downloadFile_progress_server/update_pakage/baidu.apk";//软件更新包地址

    /**
     * 查询方法有待检验
     *
     * 向服务器发送查询请求，返回查到的StringBuilder类型数据
     *
     * @param
     *            <NameValuePair> vps POST进来的参值对
     * @return StringBuilder builder 返回查到的结果
     * @throws Exception
     */
    public static StringBuilder post_to_server(List<NameValuePair> vps) {
        DefaultHttpClient httpclient = new DefaultHttpClient();
        try {
            HttpResponse response = null;
            // 创建httpost.访问本地服务器网址
            HttpPost httpost = new HttpPost(SERVER_ADDRESS);
            StringBuilder builder = new StringBuilder();

            httpost.setEntity(new UrlEncodedFormEntity(vps, HTTP.UTF_8));
            response = httpclient.execute(httpost); // 执行

            if (response.getEntity() != null) {
                // 如果服务器端JSON没写对，这句是会出异常，是执行不过去的
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(response.getEntity().getContent()));
                String s = reader.readLine();
                for (; s != null; s = reader.readLine()) {
                    builder.append(s);
                }
            }
            return builder;

        } catch (Exception e) {
            Log.e("msg",e.getMessage());
            return null;
        } finally {
            try {
                httpclient.getConnectionManager().shutdown();// 关闭连接
                // 这两种释放连接的方法都可以
            } catch (Exception e) {
                Log.e("msg",e.getMessage());
            }
        }
    }

    /**
     * 获取软件版本号
     * @param context
     * @return
     */
    public static int getVerCode(Context context) {
        int verCode = -1;
        try {
            //注意："com.example.try_downloadfile_progress"对应AndroidManifest.xml里的package="……"部分
            verCode = context.getPackageManager().getPackageInfo(
                    "com.dq.huibao", 0).versionCode;
        } catch (NameNotFoundException e) {
            Log.e("msg",e.getMessage());
        }
        return verCode;
    }
    /**
     * 获取版本名称
     * @param context
     * @return
     */
    public static String getVerName(Context context) {
        String verName = "";
        try {
            verName = context.getPackageManager().getPackageInfo(
                    "com.dq.liuhe", 0).versionName;
        } catch (NameNotFoundException e) {
            Log.e("msg",e.getMessage());
        }
        return verName;
    }

}
