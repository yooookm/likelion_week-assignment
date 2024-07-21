package study.likelionbeweekly.week7.member;

import jakarta.persistence.EntityNotFoundException;
import java.util.Objects;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.likelionbeweekly.week7.member.dto.JoinMemberRequest;
import study.likelionbeweekly.week7.member.dto.LoginMemberRequest;
import study.likelionbeweekly.week7.member.dto.UpdateMemberRequest;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    public Member loginMember(LoginMemberRequest request) {
        String loginEmail = request.email();
        String loginPassword = request.password();

        Member member = memberRepository.findByEmail(loginEmail)
                .orElseThrow(EntityNotFoundException::new);

        if (!Objects.equals(loginEmail, member.getEmail()) || !Objects.equals(loginPassword, member.getPassword())) {
            log.error("로그인 정보 일치하지 않음");
            throw new IllegalArgumentException("로그인 정보 일치하지 않음");
        }
        log.info("로그인 성공");

        return member;
    }

    @Transactional
    public void joinMember(JoinMemberRequest request) {
        String joinName = request.name();
        String joinEmail = request.email();
        String joinPassword = request.password();

        checkDuplicateEmail(joinEmail);

        Member member = new Member(joinName, joinEmail, joinPassword);
        memberRepository.save(member);
    }

    @Transactional
    public void updateMember(Long id, UpdateMemberRequest request) {
        Member member = memberRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        String updateName = request.name();
        String updateEmail = request.email();
        String updatePassword = request.password();

        checkDuplicateEmail(updateEmail);

        member.setName(updateName);
        member.setEmail(updateEmail);
        member.setPassword(updatePassword);
        log.info("업데이트 완료");
    }

    private void checkDuplicateEmail(String email) {
        Optional<Member> optionalMember = memberRepository.findByEmail(email);
        if (optionalMember.isPresent()) {
            log.error("중복 이메일");
            throw new IllegalArgumentException("중복 이메일");
        }
    }

    @Transactional
    public void deleteMember(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        member.setDeleted(true);
    }
}
