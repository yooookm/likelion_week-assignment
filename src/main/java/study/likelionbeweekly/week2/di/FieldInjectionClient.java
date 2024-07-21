package study.likelionbeweekly.week2.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FieldInjectionClient {
    // 필드 주입: 필드에 @Autowired 붙임
    @Autowired
    private MessageService messageService;

    public void processMessage(String message) {
        messageService.sendMessage(message);
    }
}
