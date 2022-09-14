package com.hsoedu.api.socket_;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 项目名：    chapter21
 * 文件名：    SocketTCP01Server
 * 创建时间：   2022/9/7 18:49
 *
 * @author crazy Chen
 * 描述：      TODO
 */
@SuppressWarnings({})
public class SocketTCP02Server {
    public static void main(String[] args) throws IOException {
        //监听本机的9999端口
        //细节，要求9999端口没有被占用
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端在9999端口监听~");
        //当没有客户端连接9999端口时，程序会阻塞，等待连接
        //如果有客户端连接，会返回一个socket对象，程序继续
        Socket accept = serverSocket.accept();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(accept.getInputStream(), "utf-8"));
        //IO读取
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
//        System.out.println(bufferedReader.readLine());
        //获取socket相关联的输出流
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream(), "utf-8"));
        bufferedWriter.write("hello,client 字符流");
        bufferedWriter.flush();
        //设置结束标记
        accept.shutdownOutput();
        bufferedReader.close();
        bufferedWriter.close();
        accept.close();
        serverSocket.close();
        System.out.println("服务端退出了");
    }
}
