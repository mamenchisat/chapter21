package com.hsoedu.api.socket_;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 项目名：    chapter21
 * 文件名：    SocketTCP01Client
 * 创建时间：   2022/9/7 18:50
 *
 * @author crazy Chen
 * 描述：      TODO
 */
public class SocketTCP01Client {
    public static void main(String[] args) throws IOException {
        //1.连接服务器端
        //解读：要连接InetAddress.getLocalHost()的9999端口，如果连接成功返回socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端 socket返回="+socket.getClass());
        //连接上后通过socket.getOutputStream(),得到和这个socket对象关联的输出流
        OutputStream outputStream = socket.getOutputStream();
        //通过输出流，写数据到数据通道
        outputStream.write("hello,server".getBytes());
        socket.shutdownOutput();
        //获取socket的InputStream
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
        }
        //关闭流对象和socket对象
        outputStream.close();
        inputStream.close();
        socket.close();
        System.out.println("客户端退出了");
    }
}
