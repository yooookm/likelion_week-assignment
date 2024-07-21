package study.likelionbeweekly.week7;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)

public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID 를 자동 생성
    private Long id;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Setter
    @Column(columnDefinition = "boolean default false")
    private boolean isDeleted;
}