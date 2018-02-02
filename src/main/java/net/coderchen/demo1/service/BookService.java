package net.coderchen.demo1.service;

import net.coderchen.demo1.model.Account;
import net.coderchen.demo1.model.Book;

/**
 * Created by Liuyuchen on 2018/02/01.
 */
public interface BookService {

    int deductLeftCount(int bookId);

    Book selectBook(int bookId);

    boolean payForABook(int bookId, Account account);
}
