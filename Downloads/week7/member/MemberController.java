package study.likelionbeweekly.week7.member;

import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import study.likelionbeweekly.week7.jwt.JwtService;
import study.likelionbeweekly.week7.member.dto.JoinMemberRequest;
import study.likelionbeweekly.week7.member.dto.LoginMemberRequest;
import study.likelionbeweekly.week7.member.dto.UpdateMemberRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;
    private final JwtService jwtService; // jwt 주입

    @GetMapping
    public ResponseEntity<String> login(@RequestBody LoginMemberRequest request){

        Member member = memberService.loginMember(request);

        String jwt = jwtService.create(member.getEmail());
        return ResponseEntity.ok()
                .header("Authorizaion", jwt)
                .body("ok");
    }

    @PostMapping
    public ResponseEntity<String> join(@RequestBody JoinMemberRequest request) {
        memberService.joinMember(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("created");
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable(name = "id") Long id,
                                         @RequestBody UpdateMemberRequest request){

        memberService.updateMember(id, request);
        return ResponseEntity.ok().body("ok");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(name = "id") Long id) {
        memberService.deleteMember(id);
        return ResponseEntity.ok().body("ok");
    }
}
