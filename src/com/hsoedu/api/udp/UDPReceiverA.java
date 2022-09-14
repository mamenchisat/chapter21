package com.hsoedu.api.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 项目名：    chapter21
 * 文件名：    UDPReceiverA
 * 创建时间：   2022/9/8 10:41
 *
 * @author crazy Chen
 * 描述：      TODO
 */
public class UDPReceiverA {
    public static void main(String[] args) throws IOException {
        //创建一个DatagramSocket 对象，准备在9999接收数据
        DatagramSocket datagramSocket = new DatagramSocket(9999);
        //构建一个 DatagramPacket对象准备接收数据
        //UDP协议的一个数据包最大为64k
        byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
        //准备接收数据，调用接收方法,将收到的数据填充到datagramPacket中，没数据发送到9999端口，会阻塞
        System.out.println("接收端等待数据~");
        datagramSocket.receive(datagramPacket);

        //当接收到数据包时，进行拆包，取出数据并显示
        int len = datagramPacket.getLength();//实际接收到的数据的字节长度
        byte[] data = datagramPacket.getData();//接收到数据
        String s = new String(data, 0, len);
        System.out.println(s);

        //==============回复消息===============

        //将需要发送的数据封装到 DatagramPacket里面
        byte[] receivedData = "好的明天见".getBytes();
        //封装的对象有这么几个对象，bytes字节数组，bytes.length，目标主机host，以及端口
        datagramPacket = new DatagramPacket(receivedData, receivedData.length,InetAddress.getByName("192.168.3.16") ,8888);
        datagramSocket.send(datagramPacket);
        //关闭
        datagramSocket.close();
        System.out.println("A端退出");
    }
}
