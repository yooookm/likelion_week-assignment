package study.likelionbeweekly.week2.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConstructorInjectionClient {
    // 생성자 주입: @Autowired 붙여서 직접 주입
    private final MessageService messageService;

    @Autowired
    public ConstructorInjectionClient(MessageService messageService) {
        this.messageService = messageService;
    }

    public void processMessage(String message) {
        messageService.sendMessage(message);
    }
}
