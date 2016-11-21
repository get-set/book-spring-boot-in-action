package com.getset.ch03.taskscheduler;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 配置类。
 * Created by Kang on 2016/11/22 0022.
 */
@Configuration
@ComponentScan("com.getset.ch03.taskscheduler")
@EnableScheduling
public class TaskSchedulerConfig {
}
