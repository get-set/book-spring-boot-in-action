package com.getset.ch03.taskexecutor;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 执行任务类。
 * 通过@Async注解表明该方法是一个异步方法，如果注解在类级别，则表明该类所有的方法都是异步方法，而这里的方法自动被注入使用ThreadPoolTaskExecuter作为TaskExecuter。
 * Created by Kang on 2016/11/21 0021.
 */
@Service
@Async
public class AsyncTaskService {
    public void execAsyncTask1(Integer i) {
        System.out.println("execAsyncTask1: " + i);
    }
    public void execAsyncTask2(Integer i) {
        System.out.println("execAsyncTask2: " + i);
    }
}
