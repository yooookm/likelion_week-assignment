## DB 삽입
### Member 테이블 삽입
```sql
INSERT INTO Member (name, phoneNum)
VALUES ('유경미', '123-456-7890'),
       ('고민석', '234-567-8901'),
       ('한종민', '345-678-9012');
```
![Untitled](img.png)

### Post 테이블 삽입
```sql
INSERT INTO Post (title, content, memberId, picture1, picture2, createAt, updateAt)
VALUES ('post1', '여자한테 인기 많아지는 법', 2, NULL, NULL, NOW(), NOW()),
       ('post2', '대학교에서 빨리 종강하는 법', 1, NULL, NULL, NOW(), NOW());
```
![Untitled](img_2.png)

### Comment 테이블 삽입
```sql
INSERT INTO Comment (content, createAt, updateAt, memberId, postId)
VALUES ('좋은 글 잘 봤습니다!', NOW(), NOW(), 1, 1),
       ('정보 공유 감사해요', NOW(), NOW(), 3, 1),
       ('재밌네요', NOW(), NOW(), 3, 2);
```
![Untitled](img_1.png)

## join 실습
### inner join
```sql
SELECT m.name AS member_name, p.title AS post_title, c.content AS comment_content
FROM Member m
         INNER JOIN Post p ON m.memberId = p.memberId
         INNER JOIN Comment c ON p.postId = c.postId;
```
![Untitled](img_3.png)

### left join
```sql
SELECT m.name AS member_name, p.title AS post_title, c.content AS comment_content
FROM Member m
         LEFT JOIN Post p ON m.memberId = p.memberId
         LEFT JOIN Comment c ON p.postId = c.postId;
```
![Untitled](img_4.png)

### right join
```sql
SELECT m.name AS member_name, p.title AS post_title, c.content AS comment_content
FROM Member m
         RIGHT JOIN Post p ON m.memberId = p.memberId
         RIGHT JOIN Comment c ON p.postId = c.postId;
```
![Untitled](img_5.png)