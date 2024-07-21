package study.likelionbeweekly.week7.post;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import study.likelionbeweekly.week7.post.dto.CreatePostRequest;
import study.likelionbeweekly.week7.post.dto.FindAllPostsResponse;
import study.likelionbeweekly.week7.post.dto.FindPostResponse;
import study.likelionbeweekly.week7.post.dto.UpdatePostRequest;

@RestController
@RequestMapping("/posts") // 공통 매핑
@RequiredArgsConstructor // 초기화
public class PostController {

    private final PostService postService;

    // 게시물 전체 조회
    @GetMapping
    public ResponseEntity<FindAllPostsResponse> findAll(){
        FindAllPostsResponse response = postService.findAllPosts();
        return ResponseEntity.ok().body(response);
    }

    // 게시물 조회 1개
    @GetMapping("/{id}")
    public ResponseEntity<FindPostResponse> find(@PathVariable(name = "id") Long id) {
        FindPostResponse response = postService.findPost(id);
        return ResponseEntity.ok().body(response);
    }

    // 게시물 등록
    @PostMapping
    public ResponseEntity<String> create(@RequestBody CreatePostRequest request) {
        postService.createPost(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("create");
    }

    // 게시물 수정
    @PatchMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable(name = "id") Long id,
                       @RequestBody UpdatePostRequest request) {
        // requestbody 에 데이터를 담앗다는 것을 명시

        postService.updatePost(id, request);
        return ResponseEntity.ok().body("ok");

    }

    // 삭제는 수정이랑 로직이 비슷

}
