package study.likelionbeweekly.week3.longcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserView {
    private BufferedReader bufferedReader;

    public UserView() {
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void displayOptions() {
        System.out.println("1. /joinPage\t2. /loginPage\t3. 종료");
    }

    public String promptForId() throws IOException {
        System.out.print("아이디 입력: ");
        return bufferedReader.readLine();
    }

    public String promptForPassword() throws IOException {
        System.out.print("비밀번호 입력: ");
        return bufferedReader.readLine();
    }

    public void showRegistrationSuccess() {
        System.out.println("회원 가입 완료");
    }

    public void showRegistrationError() {
        System.out.println("중복 아이디 가입");
    }

    public void showLoginSuccess(String id) {
        System.out.println("로그인 성공, 당신의 아이디는 " + id + " 입니다.");
    }

    public void showLoginError() {
        System.out.println("아이디 또는 비밀번호가 일치하지 않습니다.");
    }
}