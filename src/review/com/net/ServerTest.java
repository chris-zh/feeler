package net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by chris.zhang on 16-7-26.
 */
public class ServerTest {
    public static void main(String[] args) throws IOException {

        ExecutorService e = Executors.newSingleThreadExecutor();
        ExecutorService executors = Executors.newFixedThreadPool(10);
        ServerSocket serverSocket = new ServerSocket(8021);
        while (true) {
            Socket socket = serverSocket.accept();
            executors.execute(new RequestHandler(socket));
            socket.close();
        }
    }


}

class  RequestHandler implements Runnable {
    private Socket socket;

    RequestHandler(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        String result = null;
        try {
            result = parse(socket);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("客户端的请求信息：" + result);
        OutputStream outputStream = null;
        try {
            outputStream = socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter pw = new PrintWriter(outputStream);
        pw.write(response());
        pw.flush();
        try {
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        pw.close();
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private static String response() {
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

    private static String parse(Socket socket) throws IOException {
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
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

interface test1 extends Map {
   // http://vip.cocode.cc/chest/shared/713
    //http://vip.cocode.cc/chest/shared/715
}