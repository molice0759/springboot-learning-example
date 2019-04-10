package com.molice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author molice
 * @date 2019/1/20
 **/
@Component
public class SchedulerTask {

    private final static Logger logger = LoggerFactory.getLogger(SchedulerTask.class);

    private final static SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("HH:mm:ss");


    private int count = 0;

    //@Scheduled(cron = "0 22 16 * * ?")
    //@Scheduled(cron = "*/6 * * * * ?")
    private void process() {
        logger.info("this is scheduler task running " + (count++));
    }

    //@Scheduled(fixedRate = 6000)
    public void reportCurrentTime() {
        logger.info("现在的时间：" + SIMPLE_DATE_FORMAT.format(new Date()));
    }

}
