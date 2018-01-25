package net.coderchen.demo1.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Liuyuchen on 2018/01/17.
 */
public class LogTest {

    public static void main(String[] args) throws InterruptedException {
        Logger logger = LogManager.getLogger(LogTest.class);
//        Logger logger = LogManager.getLogger("mylog");
//        logger.trace("trace level");
//        logger.debug("debug level");
//        logger.info("info level");
//        logger.warn("warn level");
//        logger.error("error level");
//        logger.fatal("fatal level");
        logger.error("error level");
        logger.info("info level");
    }
}
