package study.likelionbeweekly.week3.longcode;

import java.io.IOException;

public class LongCodeApplication {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        UserView userView = new UserView();
        UserController userController = new UserController(userRepository, userView);

        try {
            userController.processUserRequest();
        } catch (IOException e) {
            System.out.println("입력 오류가 발생했습니다: " + e.getMessage());
        }
    }
}
