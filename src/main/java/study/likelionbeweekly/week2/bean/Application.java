package study.likelionbeweekly.week2.bean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
// @ComponentScan 포함
public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Application.class, args);
        ComponentBean bean = applicationContext.getBean(ComponentBean.class);
        bean.action();
    }
}
