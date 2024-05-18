package study.likelionbeweekly.week3.longcode.controller;

import study.likelionbeweekly.week3.longcode.repository.UserRepository;

public class RequestHandler {
    private UserRepository userRepository;

    public RequestHandler() {
        this.userRepository = new UserRepository();
    }

    public String processRequest(UserRepository repository, String id, String password, String requestType) {
        if ("join".equals(requestType)) {
            return handleJoin(id, password);
        } else if ("login".equals(requestType)) {
            return handleLogin(id, password);
        }
        throw new IllegalStateException("Invalid request type");
    }


    private String handleJoin(String id, String password) {
        boolean success = userRepository.save(id, password);
        if (success) {
            return "회원 가입 완료";
        } else {
            throw new IllegalStateException("회원가입 실패");
        }
    }

    private String handleLogin(String id, String password) {
        boolean isValidUser = userRepository.identifyUser(id, password);
        if (isValidUser) {
            return "로그인 성공, 당신의 아이디는 " + id + " 입니다.";
        } else {
            throw new IllegalStateException("로그인 실패");
        }
    }
}
