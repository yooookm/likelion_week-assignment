package study.likelionbeweekly.week2.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FieldInjectionClient {
    // 필드 주입: @Autowired 사용
    @Autowired
    private MessageService messageService;

    public void processMessage(String message) {
        messageService.sendMessage(message);
    }
}
