package study.likelionbeweekly.week2.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Configuration
public class AppConfig {
    @Bean
    public MyBean myBean() {
        return new MyBean();
    }
}

class MyBean {
    public void getBeanInfo() {
        System.out.println("I am bean");
    }
}
