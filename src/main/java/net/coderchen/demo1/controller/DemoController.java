package net.coderchen.demo1.controller;

import net.coderchen.demo1.model.BlogArticle;
import net.coderchen.demo1.service.BlogArticleService;
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
}
