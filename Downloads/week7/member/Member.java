package study.likelionbeweekly.week7.member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import study.likelionbeweekly.week7.BaseEntity;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)

public class Member extends BaseEntity {
    @Column(length = 16, nullable = false)
    private String name;

    @Column(length = 64, nullable = false, unique = true)
    private String email; // email 은 고유값

    @Column(length = 1024, nullable = false)
    private String password;
}
