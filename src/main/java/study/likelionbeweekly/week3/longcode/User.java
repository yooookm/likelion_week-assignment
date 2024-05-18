package study.likelionbeweekly.week3.longcode;

public class User {
    private String id;
    private String password;

    public User(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public boolean checkSameUser(String userId, String userPw) {
        if (id.equals(userId) && password.equals(userPw)) {
            return true;
        }
        return false;
    }
}