package net.coderchen.demo1.controller;

import net.coderchen.demo1.model.Account;
import net.coderchen.demo1.model.BlogArticle;
import net.coderchen.demo1.model.Book;
import net.coderchen.demo1.service.AccountService;
import net.coderchen.demo1.service.BlogArticleService;
import net.coderchen.demo1.service.BookService;
import net.coderchen.demo1.service.DemoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.IOException;
import java.util.Date;

/**
 * Created by Liuyuchen on 2018/01/22.
 */
@Controller
@RequestMapping("/demo")
public class DemoController {
    private static final Logger logger = LogManager.getLogger(DemoController.class);
    @Autowired
    private DemoService demoService;
    @Autowired
    private BlogArticleService blogArticleService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private BookService bookService;

    @Autowired
    private JedisPool jedisPool;

    @RequestMapping("/sayHello/{name}")
    public String sayHello(@PathVariable("name") String name, Model model){
        logger.info("sayHello");
        logger.info(demoService.sayHello(name));
        model.addAttribute("name", name);
        return "index";
    }

    @ResponseBody
    @RequestMapping("/insertBlogArticle")
    public String insertBlogArticle(@RequestParam("name") String name, @RequestParam("path") String path) throws IOException {
        Date date = new Date();
        BlogArticle blogArticle = new BlogArticle();
        blogArticle.setArticleName(name);
        blogArticle.setPath(path);
        blogArticle.setCreateTime(date);
        blogArticleService.add(blogArticle);
        return "1";
    }

    @RequestMapping("/redis/{name}")
    public void redisTest(@PathVariable("name") String name){
        logger.info(name);
        Jedis jedis = jedisPool.getResource();
        logger.info(jedis.get(name));
        jedis.close();
    }

    @RequestMapping("/account")
    public void updateAccount(@RequestParam("accountName") String accountName){
        Account account = accountService.selectAccount("liuyuchen");
        System.out.println(account);
        account.setAccountMoney(1000L);
        accountService.setMoney(account);
    }

    @RequestMapping("/buy")
    public void buy(@RequestParam("accountName") String accountName){
        int bookId = 1001;
        Account account = accountService.selectAccount("liuyuchen");
        boolean result = bookService.payForABook(bookId, account);
        try{
            if(result){
                System.out.println("success!");
            }
        }catch (RuntimeException e){
            e.printStackTrace();
        }
    }
}
