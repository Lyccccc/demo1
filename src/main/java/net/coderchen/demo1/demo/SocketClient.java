package net.coderchen.demo1.demo;

import java.io.*;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * Created by Liuyuchen on 2018/01/29.
 */
public class SocketClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8888);
            Writer writer = new OutputStreamWriter(socket.getOutputStream());
            String s = "helloworld";
            writer.write(s);
            writer.flush();
            writer.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
