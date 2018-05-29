package net.coderchen.demo1.demo;

import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;

/**
 * Created by Liuyuchen on 2018/03/13.
 */
public class JsoupTest {

    public static void main(String[] args) throws IOException {
        Document document = Jsoup.parse(new URL("http://huaban.com/boards/33089723"), 5000);
        Elements elements = document.select("img");
        int i = 0;
        for (Element element : elements) {
            System.out.println(element);
            String url = element.attr("src");
            System.out.println(url);
            InputStream inputStream = new URL(url).openStream();
            File file = new File("D:\\file\\" + i + ".jpg");
            OutputStream outputStream = new FileOutputStream(file);
            byte[] bytes = new byte[1024];
            int len;
            while((len = inputStream.read(bytes)) > 0){
                outputStream.write(bytes, 0, len);
            }
            outputStream.close();
            inputStream.close();
            i++;
        }

    }
}
