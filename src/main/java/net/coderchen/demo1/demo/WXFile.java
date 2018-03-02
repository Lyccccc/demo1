package net.coderchen.demo1.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by Liuyuchen on 2018/02/02.
 */
public class WXFile {
    public static void main(String[] args) {
        String sourcePath = "E:\\software\\Wechat\\Files\\WeChat Files\\lyc_0312_1992\\CustomEmotions";
        String destinationPath = "F:\\test";
        File file = new File(sourcePath);
        File[] sourceFiles = file.listFiles();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        for (int i = 0; i < sourceFiles.length; i++) {
            System.out.println("第" + i + "个文件");
            //copy一份到destinationPath
            File newFile = new File(destinationPath + File.separator + i + ".gif");
            try(FileInputStream fileInputStream = new FileInputStream(sourceFiles[i]);
                FileChannel fileChannelIn = fileInputStream.getChannel();
                FileOutputStream fileOutputStream = new FileOutputStream(newFile);
                FileChannel fileChannelOut = fileOutputStream.getChannel()){
                int len;
                while((len = fileChannelIn.read(byteBuffer)) != -1){
                    byteBuffer.flip();
                    int outLength;
                    while((outLength = fileChannelOut.write(byteBuffer)) != 0){
//                        System.out.println("读取长度:" + len);
//                        System.out.println("写入长度:" + outLength);
                    }
                    byteBuffer.clear();
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }
}
