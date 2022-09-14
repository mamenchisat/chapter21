package com.hsoedu.api.upload;

import com.hsoedu.api.StreamUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 项目名：    chapter21
 * 文件名：    TCPFileUploadServer
 * 创建时间：   2022/9/7 21:04
 *
 * @author crazy Chen
 * 描述：      TODO
 */
public class TCPFileUploadServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务端监听8888");
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = StreamUtils.streamToByteArray(inputStream);
        String destPath = "src\\xiaogong.png";
        FileOutputStream fileOutputStream = new FileOutputStream(destPath);
        fileOutputStream.write(bytes);
        //向客户端回复收到文件
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("收到文件".getBytes());
        outputStream.flush();
        socket.shutdownOutput();
        outputStream.close();
        fileOutputStream.close();
        inputStream.close();
        socket.close();
    }
}
