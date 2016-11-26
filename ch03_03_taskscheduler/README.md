## 3.3 定时任务
Spring中进行定时任务的配置非常简单：
1. 在配置类中使用注解@EnableScheduling来开启计划任务的支持；
2. 在任务执行类中在执行方法上使用注解@Scheduled来定义不同计划类型的任务，比如cron、fixDelay、fixRate等。