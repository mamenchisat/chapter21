package com.hsoedu.api.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 项目名：    chapter21
 * 文件名：    UDPSenderB
 * 创建时间：   2022/9/8 10:41
 *
 * @author crazy Chen
 * 描述：      TODO
 */
public class UDPSenderB {
    public static void main(String[] args) throws IOException {
        //创建 DatagramSocket对象，准备发送和接收数据
        DatagramSocket datagramSocket = new DatagramSocket(8888);

        //将需要发送的数据封装到 DatagramPacket里面
        byte[] bytes = "hello 明天吃火锅".getBytes();
        //封装的对象有这么几个对象，bytes字节数组，bytes.length，目标主机host，以及端口
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length,InetAddress.getByName("192.168.3.16") ,9999);
        datagramSocket.send(datagramPacket);

        //============接收回复的消息============
        byte[] record = new byte[1024];
        datagramPacket = new DatagramPacket(record, record.length);
        datagramSocket.receive(datagramPacket);
        int len = datagramPacket.getLength();//实际接收到的数据的字节长度
        byte[] data = datagramPacket.getData();//接收到数据
        String s = new String(data, 0, len);
        System.out.println(s);

        datagramSocket.close();
        System.out.println("B端退出");

    }
}
