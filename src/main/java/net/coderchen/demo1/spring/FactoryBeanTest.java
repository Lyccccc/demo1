package net.coderchen.demo1.spring;

import net.coderchen.demo1.model.Book;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 * Created by Liuyuchen on 2018/05/10.
 */
public class FactoryBeanTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/application-factory.xml");
        System.out.println(applicationContext.getBean("&demoFactoryBean"));

        Book book1 = (Book) applicationContext.getBean("book");
        Book book2 = (Book) applicationContext.getBean("book");
        System.out.println(book1);
        System.out.println(book2);
        System.out.println(book1 == book2);
        System.out.println(book1.equals(book2));
    }
}
