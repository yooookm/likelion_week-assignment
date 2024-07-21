package study.likelionbeweekly.week2.di;

public class SimpleMessageService implements MessageService {
    @Override
    public void sendMessage(String message) {
        System.out.println("Message: " + message);
    }
}