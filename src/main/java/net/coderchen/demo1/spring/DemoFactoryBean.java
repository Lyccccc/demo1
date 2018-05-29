package net.coderchen.demo1.spring;

import net.coderchen.demo1.model.Book;
import org.springframework.beans.factory.FactoryBean;

/**
 * Created by Liuyuchen on 2018/05/10.
 */
public class DemoFactoryBean implements FactoryBean<Book> {
    @Override
    public Book getObject() throws Exception {
        return new Book();
    }

    @Override
    public Class<?> getObjectType() {
        return Book.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
