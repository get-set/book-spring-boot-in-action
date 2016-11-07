package ch01.di;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * This is a configuration class.
 * Created by Kang on 2016/11/7 0007.
 */

// 声明当前类是一个配置类
@Configuration
@ComponentScan("ch01.di")
public class DiConfig {
}
