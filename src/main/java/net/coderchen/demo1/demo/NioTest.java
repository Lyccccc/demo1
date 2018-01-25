package net.coderchen.demo1.demo;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;

/**
 * Created by Liuyuchen on 2018/01/23.
 */
public class NioTest {
    public static void main(String[] args) {
//        nioRead();
//        nioWrite();
//        nioReadAndWrite();
        channelDirect();
    }

    public static void nioRead(){
        try(FileInputStream fileInputStream = new FileInputStream(new File("D:\\file\\a.txt"));
            FileChannel fileChannel = fileInputStream.getChannel()){
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            int length;
            while((length = fileChannel.read(byteBuffer)) != -1){
                //读取后，将位置置为0，将limit置为容量, 以备下次读入到字节缓冲中，从0开始存储
                byteBuffer.clear();
                byte[] bytes = byteBuffer.array();
                System.out.write(bytes, 0, length);
            }
            fileChannel.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }

    public static void nioWrite(){
        String fileName = "D:\\file\\b.txt";
        try (FileOutputStream fileOutputStream = new FileOutputStream(new File(fileName));
             FileChannel fileChannel = fileOutputStream.getChannel()){
//            ByteBuffer byteBuffer = Charset.forName("utf8").encode("你好你好你好你好你好");
            ByteBuffer byteBuffer = ByteBuffer.wrap("helloworld".getBytes());
            int length = 0;
            while ((length = fileChannel.write(byteBuffer)) != 0) {
                /*
                 * 注意，这里不需要clear，将缓冲中的数据写入到通道中后 第二次接着上一次的顺序往下读
                 */
                System.out.println("写入长度:" + length);
            }
            fileChannel.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void nioReadAndWrite(){
        try( FileInputStream fileInputStream = new FileInputStream(new File("D:\\file\\a.txt"));
             FileOutputStream fileOutputStream = new FileOutputStream(new File("D:\\file\\b.txt"));
             FileChannel fileChannelIn = fileInputStream.getChannel();
             FileChannel fileChannelOut = fileOutputStream.getChannel()){
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            int length;
            while((length = fileChannelIn.read(byteBuffer)) != -1){
                //写模式->读模式
                byteBuffer.flip();
                int outLength;
                while((outLength = fileChannelOut.write(byteBuffer)) != 0){
                    System.out.println("读取长度:" + length);
                    System.out.println("写入长度:" + outLength);
                }
                //读完之后，准备再次写入
                byteBuffer.clear();
            }
            fileChannelOut.close();
            fileChannelIn.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //两个FileChannel直接传递数据
    public static void channelDirect(){
        try(FileInputStream fileInputStream = new FileInputStream(new File("D:\\file\\a.txt"));
            FileOutputStream fileOutputStream = new FileOutputStream(new File("D:\\file\\b.txt"));
            FileChannel fileChannelIn = fileInputStream.getChannel();
            FileChannel fileChannelOut = fileOutputStream.getChannel()) {
            long position = 0 ;
            long count = fileChannelIn.size();
//            fileChannelOut.transferFrom(position, count, fileChannelIn);
            fileChannelOut.transferFrom(fileChannelIn, position, count);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void selectorTest(){
        try (Selector selector = Selector.open();){

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
