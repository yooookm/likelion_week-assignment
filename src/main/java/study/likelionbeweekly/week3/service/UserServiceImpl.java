package study.likelionbeweekly.week3.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import study.likelionbeweekly.week3.domain.User;
import study.likelionbeweekly.week3.repository.UserRepository;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveUser(String id, String password) {
        User user = createUser(id, password);
        userRepository.save(user);
    }

    private User findUser(String id) {
        return userRepository.findById(id);
    }

    private User createUser(String id, String password) {
        User user = findUser(id);

        if (user == null) {
            return new User(id, password);
        }
        log.error("이미 존재하는 사용자입니다");
        throw new IllegalStateException("아이디 중복");
    }

    @Override
    public User login(String id, String password, Model model) {
        User user = findUser(id);
        return compare(id, password, user, model);
    }

    /**
     * 이 코드는 user 의 정보가 일치하는지 확인합니다. 일치한다면 페이지에 id 정보를 반환하고, 그렇지 않다면 에러를 일으킵니다.
     */
    private User compare(String id, String password, User user, Model model) {
        if (id.equals(user.getId()) && password.equals(user.getPassword())) {
            model.addAttribute("id", id);
            return user;
        }
        log.error("아이디와 비밀번호가 일치하지 않습니다.");
        throw new IllegalStateException("로그인 실패");
    }
}
