package net;

import java.io.*;
import java.net.*;

/**
 * Created by chris.zhang on 16-7-26.
 */
public class NetTest {
    public static void main(String[] args) throws IOException {



        Socket socket = new Socket("localhost", 8021);

        OutputStream outputStream = socket.getOutputStream();
        PrintWriter writer = new PrintWriter(outputStream);
        writer.write("fuck");
        writer.flush();
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String result = bufferedReader.readLine();
        System.out.println("result = " + result);
        inputStream.close();
        bufferedReader.close();
        writer.close();
        outputStream.close();
//        inputStream.close();
//        outputStream.close();
//        socket.close();
//        String result = parse(socket);
//        System.out.println("服务器的返回信息: " + result);
    }

}
