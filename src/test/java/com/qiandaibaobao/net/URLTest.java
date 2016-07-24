package com.qiandaibaobao.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 2016/7/12 0012.
 */
public class URLTest {

    public static void main(String[] args){
        try {
            URL baobao = new URL("http://www.qiandaibaobao.com");
            InputStream inputStream = baobao.openStream();
            InputStreamReader reader = new InputStreamReader(inputStream, "UTF-8");
            BufferedReader br = new BufferedReader(reader);
            String data = br.readLine();
            while (data != null) {
                System.out.println(data);
                data = br.readLine();
            }

            br.close();
            reader.close();
            inputStream.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
