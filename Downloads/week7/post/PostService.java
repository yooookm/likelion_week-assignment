package study.likelionbeweekly.week7.post;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.processing.Find;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import study.likelionbeweekly.week7.member.Member;
import study.likelionbeweekly.week7.member.MemberRepository;
import study.likelionbeweekly.week7.post.dto.CreatePostRequest;
import study.likelionbeweekly.week7.post.dto.FindAllPostsResponse;
import study.likelionbeweekly.week7.post.dto.FindPostResponse;
import study.likelionbeweekly.week7.post.dto.UpdatePostRequest;

import java.util.List;

@Slf4j // 로깅
@Service
@RequiredArgsConstructor
// @Transactional(readOnly = true)

public class PostService {

    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    public FindAllPostsResponse findAllPosts(){ // 디비에 저장된 모든 포스트들 가져오는 거
        List<Post> posts = postRepository.findAll(); // 리스트 형태로 모든 데이터를 가져옴.
        return FindAllPostsResponse.of(posts); // of
    }

    // 게시물 조회
    // 반환 타입 주의
    public FindPostResponse findPost(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        // 찾는 게시물이 없을 때 null 이 반환되는 특징, entitynotfound라는 예외를 만들게 됨.

        return new FindPostResponse(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getMember().getName(),
                post.getCreatedAt().toString());

    }

    @Transactional
    // set 에서 예외가 발생했을 때 혹시 모를 장애에 대비하기 위함.
    public void updatePost(Long id, UpdatePostRequest request) {
        Post post = postRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        // 효율적인 코드 사용
        post.setTitle(request.title());
        post.setContent(request.content());
    }

    @Transactional // 예외 상황에 대해 롤백하기
    public void createPost(CreatePostRequest request) {
        // dto 에서 값 꺼내기
        String createTitle = request.title();
        String creatContent = request.content();
        Long memberId = request.memberId();

        Member member = memberRepository.findById(memberId)
                .orElseThrow(EntityNotFoundException::new);

        Post post = new Post(createTitle, creatContent, member); // post 객체
        postRepository.save(post);
    }

}