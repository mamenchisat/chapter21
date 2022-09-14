package com.hsoedu.api;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 项目名：    chapter21
 * 文件名：    API_
 * 创建时间：   2022/9/7 18:14
 *
 * @author crazy Chen
 * 描述：      TODO
 */
public class API_ {
    public static void main(String[] args) throws UnknownHostException {
//        获取本机host
//        InetAddress localAddress = InetAddress.getLocalHost();
//        System.out.println(localAddress);
//        根据主机名称获取host
//        System.out.println(InetAddress.getByName("Mamenchisat"));

        //根据域名获取host
        InetAddress host = InetAddress.getByName("www.alibaba.com");
        //根据host获取主机名或域名
        System.out.println(host.getHostName());
        System.out.println(host.getHostAddress());
    }
}
