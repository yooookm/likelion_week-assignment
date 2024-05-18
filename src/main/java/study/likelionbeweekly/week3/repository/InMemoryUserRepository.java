package study.likelionbeweekly.week3.repository;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;
import study.likelionbeweekly.week3.domain.User;

@Repository
public class InMemoryUserRepository implements UserRepository {

    // DB 생성
    private static final Map<String, User> users = new HashMap<>();

    /*  UserRepository 인터페이스로 함수 구현 강제  */
    @Override
    public void save(User user) {
        final String id = user.getId();
        // DB 추가
        users.put(id, user);
    }

    @Override
    public User findById(String id) {
        return users.get(id);
    }
}
