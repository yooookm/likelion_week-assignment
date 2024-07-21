package study.likelionbeweekly.week7.post.dto;

import org.hibernate.annotations.processing.Find;
import study.likelionbeweekly.week7.post.Post;

import java.util.List;

public record FindAllPostsResponse(List<FindPost> posts) {

    public static FindAllPostsResponse of (List<Post> posts){
        return new FindAllPostsResponse(
                posts.stream()
                        .map(post -> new FindPost(
                                post.getId(),
                                post.getTitle(),
                                post.getMember().getName()))
                        .toList());
    }

    record FindPost(Long id, String title, String memberName) { // 데이터 정제

    }

}
