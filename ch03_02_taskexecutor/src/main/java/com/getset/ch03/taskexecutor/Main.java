package com.getset.ch03.taskexecutor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 运行类。
 * Created by Kang on 2016/11/21 0021.
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskExecutorConfig.class);
        AsyncTaskService asyncTaskService = context.getBean(AsyncTaskService.class);

        for (int i=0; i<10; i++) {
            asyncTaskService.execAsyncTask1(i);
            asyncTaskService.execAsyncTask2(i);
        }
    }
}
