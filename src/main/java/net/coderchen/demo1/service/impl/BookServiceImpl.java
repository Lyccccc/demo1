package net.coderchen.demo1.service.impl;

import net.coderchen.demo1.dao.AccountMapper;
import net.coderchen.demo1.dao.BookMapper;
import net.coderchen.demo1.model.Account;
import net.coderchen.demo1.model.Book;
import net.coderchen.demo1.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Liuyuchen on 2018/02/01.
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public int deductLeftCount(int bookId) {
        return bookMapper.deductLeftCount(bookId);
    }

    @Override
    public Book selectBook(int bookId) {
        return bookMapper.selectBook(bookId);
    }

    @Override
    @Transactional
    public boolean payForABook(int bookId, Account account) {
        System.out.println(account);
        //先减库存，再减余额
        bookMapper.deductLeftCount(bookId);
        Book book = selectBook(bookId);
        System.out.println(book);
        long accountMoney = account.getAccountMoney() - book.getBookMoney();
        if(accountMoney > 0){
            account.setAccountMoney(account.getAccountMoney() - book.getBookMoney());
            accountMapper.setMoney(account);
            return true;
        }else{
            throw new RuntimeException("账户余额不足！");
        }
    }
}
