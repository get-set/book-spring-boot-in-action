## 2.5 事件监听
本例演示了Bean之间进行事件传递的方法。当一个Bean执行完操作后需要另一个Bean知道，那么就需要后者监听前者。
Spring的时间需要遵循如下流程：
1. 自定义事件，继承ApplicationEvent；
2. 定义事件监听器，实现ApplicationListener；
3. 使用容器发布事件。