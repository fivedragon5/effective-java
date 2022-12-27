package me.whiteship.chapter01.item01;

import me.whiteship.hello.ChineseHelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//서비스 등록 제공자 API
//서비스 구현체를 등록하는것
@Configuration
public class AppConfig {

    @Bean
    public HelloService helloService() {
        return new ChineseHelloService();
    }

}
