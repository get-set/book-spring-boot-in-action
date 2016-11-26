## Bean的Scope
本例演示了Spring Beans的不同scope产生的不同效果：
1. Singleton，默认为单例模式，也就是整个容器中只有一个对象，每次getBean获取到的时候同一个对象；
2. Prototype，每次getBean的时候会返回一个新的对象；
3. Request，给每次http request创建一个新的bean；
4. Session，给每个http session创建一个新的bean。