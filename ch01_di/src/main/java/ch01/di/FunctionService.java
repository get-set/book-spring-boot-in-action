package ch01.di;

import org.springframework.stereotype.Service;

/**
 * This is a function service class.
 * Created by Kang on 2016/10/23 0023.
 */

// 使用@Service注解声明这个类是Spring管理的一个bean
@Service
public class FunctionService {
    public String sayHello(String word) {
        return "Hello, " + word + "!";
    }
}
