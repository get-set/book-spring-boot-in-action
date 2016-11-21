package com.getset.ch03.taskscheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 计划任务执行类。
 * Created by Kang on 2016/11/22 0022.
 */
@Service
public class ScheduledTaskService {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        System.out.println("Every 5 secs: " + dateFormat.format(new Date()));
    }

    @Scheduled(cron = "*/5 19 0 * * *")
    public void fixTimeExecution() {
        System.out.println("Fixed time: " + dateFormat.format(new Date()));
    }
}
