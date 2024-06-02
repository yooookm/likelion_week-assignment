-- 이너 조인
SELECT m.name AS member_name, p.title AS post_title, c.content AS comment_content
FROM Member m
         INNER JOIN Post p ON m.memberId = p.memberId
         INNER JOIN Comment c ON p.postId = c.postId;

-- left 조인
SELECT m.name AS member_name, p.title AS post_title, c.content AS comment_content
FROM Member m
         LEFT JOIN Post p ON m.memberId = p.memberId
         LEFT JOIN Comment c ON p.postId = c.postId;

-- right 조인
SELECT m.name AS member_name, p.title AS post_title, c.content AS comment_content
FROM Member m
         RIGHT JOIN Post p ON m.memberId = p.memberId
         RIGHT JOIN Comment c ON p.postId = c.postId;