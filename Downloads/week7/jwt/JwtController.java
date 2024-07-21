package study.likelionbeweekly.week7.jwt;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.web.ReactiveSortHandlerMethodArgumentResolver;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import study.likelionbeweekly.week7.member.Member;
import study.likelionbeweekly.week7.post.dto.FindAllPostsResponse;

@Slf4j
@RestController
@RequiredArgsConstructor

public class JwtController {

    private final JwtService jwtService;

    @GetMapping("/parse")
    public ResponseEntity<Member> parse(@RequestHeader("Authorization") String token){
        Member member = jwtService.parse(token);
        log.info("member={}", member);

        return ResponseEntity.ok().body(member);
    }
}
