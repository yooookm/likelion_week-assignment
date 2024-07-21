package study.likelionbeweekly.week7.jwt;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import study.likelionbeweekly.week7.member.Member;
import study.likelionbeweekly.week7.member.MemberRepository;

import java.nio.charset.StandardCharsets;
import java.util.Date;

@Slf4j
@Service
@RequiredArgsConstructor
public class JwtService {
    
    private final MemberRepository memberRepository;

    @Value("${jwt.secretKey}")
    private String secretKey;

    // token create
    public String create(String email) {

        // Bearer 프리픽스 사용
        return "Bearer " + Jwts.builder()
                .subject("likelion token")
                .issuer("likelion server")
                .audience().and().id(email) // email 식별자
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)) // 토큰 만료 설정
                .claim("email", email)
                .signWith(Keys.hmacShaKeyFor(
                        secretKey.getBytes(StandardCharsets.UTF_8))) // 비밀키 암호화
                .compact();
    }

    // parsing
    public Member parse(String token){
        try{
            String email = getEmail(token);
            return memberRepository.findByEmail(email)
                    .orElseThrow(EntityNotFoundException::new);
        }
        catch (ExpiredJwtException e) {
            log.error("토큰 만료", e);
            throw new IllegalArgumentException("토큰 만료", e);
        } catch (UnsupportedJwtException e) {
            log.error("미지원 토큰", e);
            throw new IllegalArgumentException("미지원 토큰", e);
        } catch (MalformedJwtException e) {
            log.error("토큰 형식 오류", e);
            throw new IllegalArgumentException("토큰 형식 오류", e);
        } catch (SignatureException e) {
            log.error("유효하지 않은 토큰 서명", e);
            throw new IllegalArgumentException("유효하지 않은 토큰 서명", e);
        }

    }

    private String getEmail(String token) {
        return Jwts.parser()
                .verifyWith(Keys.hmacShaKeyFor(
                        secretKey.getBytes(StandardCharsets.UTF_8)))
                .build()
                .parseSignedClaims(token.substring(7))
                .getPayload()
                .get("email", String.class);
    }
}
