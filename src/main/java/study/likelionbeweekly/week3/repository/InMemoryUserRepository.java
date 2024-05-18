package study.likelionbeweekly.week3.repository;

import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import study.likelionbeweekly.week3.domain.User;

@Slf4j
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
        log.info("회원가입이 성공적으로 완료되었습니다. 아이디는 {}입니다", id);

    }

    @Override
    public User findById(String id) {
        return users.get(id);
    }
}
