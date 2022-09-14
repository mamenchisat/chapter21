package com.hsoedu.api.upload;


import com.hsoedu.api.StreamUtils;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 项目名：    chapter21
 * 文件名：    TCPFileUploadClient
 * 创建时间：   2022/9/7 21:03
 *
 * @author crazy Chen
 * 描述：      TODO
 */
public class TCPFileUploadClient {
    public static void main(String[] args) throws Exception {
        String srcFilePath = "d:\\xiaogong.png";
        InputStream inputStream = new FileInputStream(srcFilePath);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        byte[] bytes = StreamUtils.streamToByteArray(bufferedInputStream);
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(bytes);
        socket.shutdownOutput();
        //读取服务端回复
        InputStream inputStream1 = socket.getInputStream();
        //使用Stream方法，将input流转换成字符串
        java.lang.String string = StreamUtils.streamToString(inputStream1);
        System.out.println(string);
        inputStream1.close();
        bufferedInputStream.close();
        inputStream.close();
        socket.close();
    }
}
