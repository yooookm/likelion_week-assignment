package study.likelionbeweekly.week2.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "study.likelionbeweekly.week2.di") // 'your.package.name'을 해당 패키지 이름으로 바꾸세요.
public class AppConfig {

    @Bean
    public MessageService messageService() {
        return new SimpleMessageService();
    }
}