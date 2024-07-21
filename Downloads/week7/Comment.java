package study.likelionbeweekly.week7;

import jakarta.persistence.*;
import lombok.*;
import study.likelionbeweekly.week7.post.Post;
import study.likelionbeweekly.week7.member.Member;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)

public class Comment extends BaseEntity {
    @Setter
    @Column(length = 256, nullable = false)
    private String content;

    @JoinColumn(name = "member_id")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Member member;

    @JoinColumn(name = "post_id")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Post post;
}
