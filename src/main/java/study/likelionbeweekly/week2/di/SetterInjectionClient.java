package study.likelionbeweekly.week2.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SetterInjectionClient {
    private MessageService messageService;

    @Autowired
    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    public void processMessage(String message) {
        messageService.sendMessage(message);
    }
}
