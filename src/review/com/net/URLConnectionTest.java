package net;

import sun.net.www.http.HttpCaptureInputStream;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by chris.zhang on 16-7-27.
 */
public class URLConnectionTest {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://www.qiandaibaobao.com");
        URLConnection connection = url.openConnection();
        String result = connection.getContentType();
        System.out.println("result = " + result);
        InputStream inputStream = connection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String data = bufferedReader.readLine();
        System.out.println("data = " + data);
        while (data != null) {
            data = bufferedReader.readLine();
            System.out.println("data = " + data);
        }
        connection.connect();
    }
}
