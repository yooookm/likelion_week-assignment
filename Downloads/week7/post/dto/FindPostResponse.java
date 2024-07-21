package study.likelionbeweekly.week7.post.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class FindPostResponse {
    // post 응답 양식
    /*
    {
	"id": 1, // 게시글 ID
	"title": "게시글 제목",
	"content": "게시글 내용",
	"memberName": "작성자 이름"
	"createdAt" : "2024-06-08 13:12:11"
}
     */

    private final Long id; //초기화 필요
    private final String title;
    private final String content;
    private final String memberName;
    private final String createdAt;
}
