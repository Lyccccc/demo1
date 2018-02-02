package net.coderchen.demo1.dao;

import net.coderchen.demo1.model.Book;

public interface BookMapper {
    int insert(Book record);

    int insertSelective(Book record);

    int deductLeftCount(int bookId);

    Book selectBook(int bookId);
}