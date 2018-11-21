package net.coderchen.demo1.demo;

import java.io.*;

/**
 * @Author Liuyuchen
 * @Date 2018/10/24
 * @Description
 */
public class FetchWXImg {

    public static void main(String[] args) throws IOException {
        File fromFile = new File("E:\\test\\1");
        InputStream inputStream = new FileInputStream(fromFile);
        File toFile = new File("E:\\test\\toFile.gif");
        if(!toFile.exists()){
            toFile.createNewFile();
        }else{
            toFile.delete();
            toFile.createNewFile();
        }
        OutputStream outputStream = new FileOutputStream(toFile);
        byte[] bytes = new byte[6];
        int len;
        int index = 0;
        while((len = inputStream.read(bytes)) != -1){
            if(index == 0){
                index++;
                showBytes(bytes);
                continue;
            }else{
                outputStream.write(bytes, 0, len);
            }
        }
    }

    public static void showBytes(byte[] bytes){
        for(byte b : bytes){
            System.out.print(b + " ");
        }
        System.out.println("\n");
        System.out.println("a7 21 46 4c 89 f6 ff 22  ");
    }
}
