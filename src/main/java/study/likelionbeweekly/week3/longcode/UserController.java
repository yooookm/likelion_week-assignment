package study.likelionbeweekly.week3.longcode;

import java.io.IOException;

public class UserController {
    private UserRepository userRepository;
    private UserView userView;

    public UserController(UserRepository userRepository, UserView userView) {
        this.userRepository = userRepository;
        this.userView = userView;
    }

    public void processUserRequest() throws IOException {
        int number;
        do {

            number = userView.displayOptions();
            switch (number) {
                case 1:
                    register();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    return;
            }
        } while (true);
    }

    private void register() throws IOException {
        String id = userView.promptForId();
        String password = userView.promptForPassword();
        boolean result = userRepository.save(id, password);
        if (result) {
            userView.showRegistrationSuccess();
        } else {
            userView.showRegistrationError();
        }
    }

    private void login() throws IOException {
        String id = userView.promptForId();
        String password = userView.promptForPassword();
        boolean result = userRepository.identifyUser(id, password);
        if (result) {
            userView.showLoginSuccess(id);
        } else {
            userView.showLoginError();
        }
    }
}