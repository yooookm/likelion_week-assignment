USE YOO;

CREATE TABLE `Member`
(
    `memberId` BIGINT       NOT NULL AUTO_INCREMENT COMMENT 'Auto increment',
    `name`     VARCHAR(40)  NOT NULL,
    `phoneNum` VARCHAR(100) NOT NULL,
    `status`   BIT          NOT NULL DEFAULT 1,
    PRIMARY KEY (`memberId`)
);

CREATE TABLE `Post`
(
    `postId`   BIGINT        NOT NULL AUTO_INCREMENT COMMENT 'Auto increment',
    `memberId` BIGINT        NOT NULL,
    `title`    VARCHAR(255)  NOT NULL,
    `content`  VARCHAR(1000) NOT NULL,
    `picture1` TEXT          NULL,
    `picture2` TEXT          NULL,
    `createAt` TIMESTAMP     NOT NULL DEFAULT current_timestamp,
    `updateAt` TIMESTAMP     NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp,
    `status`   BIT           NOT NULL DEFAULT 1,
    CONSTRAINT `FK_Post_Member` FOREIGN KEY (`memberId`) REFERENCES `Member` (`memberId`),
    PRIMARY KEY (`postId`)
);

CREATE TABLE `Comment`
(
    `commentId` BIGINT       NOT NULL AUTO_INCREMENT COMMENT 'Auto increment',
    `content`   VARCHAR(300) NOT NULL,
    `createAt`  TIMESTAMP    NOT NULL DEFAULT current_timestamp,
    `updateAt`  TIMESTAMP    NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp,
    `status`    BIT          NOT NULL DEFAULT 1,
    `memberId`  BIGINT       NOT NULL,
    `postId`    BIGINT       NOT NULL,
    PRIMARY KEY (`commentId`),
    CONSTRAINT `FK_Comment_Member` FOREIGN KEY (`memberId`) REFERENCES `Member` (`memberId`),
    CONSTRAINT `FK_Comment_Post` FOREIGN KEY (`postId`) REFERENCES `Post` (`postId`)
);

INSERT INTO Member (name, phoneNum)
VALUES ('유경미', '123-456-7890'),
       ('고민석', '234-567-8901'),
       ('한종민', '345-678-9012');


INSERT INTO Post (title, content, memberId, picture1, picture2, createAt, updateAt)
VALUES ('post1', '여자한테 인기 많아지는 법', 2, NULL, NULL, NOW(), NOW()),
       ('post2', '대학교에서 빨리 종강하는 법', 1, NULL, NULL, NOW(), NOW());

INSERT INTO Comment (content, createAt, updateAt, memberId, postId)
VALUES ('좋은 글 잘 봤습니다!', NOW(), NOW(), 1, 1),
       ('정보 공유 감사해요', NOW(), NOW(), 3, 1),
       ('재밌네요', NOW(), NOW(), 3, 2);