package net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by chris.zhang on 16-7-26.
 */
public class ServerTest {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8021);
        while (true) {
            Socket socket = serverSocket.accept();
            String result = parse(socket);
            System.out.println("客户端的请求信息：" + result);
            if ("shutdown".equals(result)) {
                break;
            }
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(outputStream);
            pw.write(response());
            pw.flush();
            outputStream.close();
            pw.close();
            socket.close();
        }
    }

    public static String response() {
        StringBuilder builder = new StringBuilder();
        //这里是header
        builder.append("HTTP/1.1 200 OK");
        builder.append("\r\n");
        builder.append("Content-Type: text/html");
        builder.append("\r\n");
        builder.append("\r\n");
        //这里是body
        builder.append("<html><head></head><body><button>click me</button></body></html>");
        System.out.println("builder = " + builder.toString());
        return builder.toString();
    }

    public static String parse(Socket socket) throws IOException {
        InputStream inputStream = socket.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String data = bufferedReader.readLine();
        StringBuilder result = new StringBuilder();
        if (data != null) {
            result.append(data);
        }
        for(;;) {
            data = bufferedReader.readLine();
            if (data == null||"".equals(data)||"null".equals(data)) {
                break;
            }
            result.append(data);

        }
        return result.toString();
    }
}
