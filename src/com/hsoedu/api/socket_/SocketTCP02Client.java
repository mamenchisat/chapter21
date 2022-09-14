package com.hsoedu.api.socket_;

import javax.naming.MalformedLinkException;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 项目名：    chapter21
 * 文件名：    SocketTCP01Client
 * 创建时间：   2022/9/7 18:50
 *
 * @author crazy Chen
 * 描述：   字符流   TODO
 */
@SuppressWarnings({})
public class SocketTCP02Client {
    public static void main(String[] args) throws IOException {
        //1.连接服务器端
        //解读：要连接InetAddress.getLocalHost()的9999端口，如果连接成功返回socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端 socket返回=" + socket.getClass());
        //连接上后通过socket.getOutputStream(),得到和这个socket对象关联的输出流
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"));
        //通过输出流，写数据到数据通道
        bufferedWriter.write("hello,server 字符流");
        bufferedWriter.flush();//如果使用字符流，需要手动刷新，否则不会写入通道
        socket.shutdownOutput();
        //获取socket的InputStream
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
//        System.out.println(bufferedReader.readLine());
        //关闭流对象和socket对象
        bufferedWriter.close();
        bufferedReader.close();
        socket.close();
        System.out.println("客户端退出了");
    }
}
