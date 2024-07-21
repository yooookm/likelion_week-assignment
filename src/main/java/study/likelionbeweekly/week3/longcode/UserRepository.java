package study.likelionbeweekly.week3.longcode;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private static final Map<String, User> users = new HashMap<>();

    public boolean save(String id, String pw) {
        if (checkUserExist(id)) {
            return false;
        }

        User newUser = new User(id, pw);
        addUser(id, newUser);

        return true;
    }

    public boolean identifyUser(String id, String pw) {
        if (checkUserExist(id)) {
            User findUsers = findById(id);
            if (findUsers.checkSameUser(id, pw)) {
                return true;
            }
        }
        return false;

    }

    // DB가 변경될 것을 고려하여 해쉬맵 함수를 일반 함수로 대체하였습니다.
    private User findById(String id) {
        return users.get(id);
    }

    private boolean checkUserExist(String id) {
        return users.containsKey(id);
    }

    private void addUser(String id, User user) {
        users.put(id, user);
    }
}
