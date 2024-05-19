package study.likelionbeweekly.week3.longcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserView {
    private BufferedReader bufferedReader;

    public UserView() {
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public int displayOptions() throws IOException {
        System.out.println("1. /joinPgage\t2. /loginPage\t3. Exit");
        int number = Integer.parseInt(bufferedReader.readLine());
        return number;
    }

    public String promptForId() throws IOException {
        System.out.print("Enter ID: ");
        return bufferedReader.readLine();
    }

    public String promptForPassword() throws IOException {
        System.out.print("Enter password: ");
        return bufferedReader.readLine();
    }

    public void showRegistrationSuccess() {
        System.out.println("Registration successful");
    }

    public void showRegistrationError() {
        System.out.println("ID already in use");
    }

    public void showLoginSuccess(String id) {
        System.out.println("Login successful, your ID is " + id + ".");
    }

    public void showLoginError() {
        System.out.println("ID or password does not match.");
    }
}
