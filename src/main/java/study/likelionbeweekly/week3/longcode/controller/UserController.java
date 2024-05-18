package study.likelionbeweekly.week3.longcode.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import study.likelionbeweekly.week3.longcode.repository.UserRepository;
import study.likelionbeweekly.week3.longcode.view.UserView;

public class UserController {
    private UserRepository userRepository;
    private UserView userView;
    private BufferedReader bufferedReader;

    public UserController(UserRepository userRepository, UserView userView) {
        this.userRepository = userRepository;
        this.userView = userView;
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void processUserRequest() throws IOException {
        int number;
        do {
            userView.displayOptions();
            number = Integer.parseInt(bufferedReader.readLine());
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