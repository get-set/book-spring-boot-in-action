## 4.4 自定义HttpMessageConverter

`HttpMessageConverter`用于处理request和response中的数据。
本例中，自定义了一个`MyMsgConverter`。
1. 其继承自`AbstractHttpMessageConverter`，并实现了`readInternal`和`writeInternal`两个方法，分别用于处理request数据和response数据；
2. 然后在配置类中配置MessageConverter，配置时有两种方法：
* `configureMessageConverter`会覆盖掉SpringMVC默认注册的多个HttpMessageConverter；
* `extendMessageConverter`仅增加一个指定的HttpMessageConverter。
3. 最后编写一个controller。
测试时使用RestClient发送请求，contentType为“application/x-wisely”，data为“123-zhangsan”，观察结果。
