package toyproject.account.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import toyproject.account.type.AccountStatus;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
@Entity // 설정클래스라고 보면 된다.
public class Account {

    @Id // Account의 pk로 지정
    @GeneratedValue
    private Long id;

    @ManyToOne
    private AccountUser accountUser;

    private String accountNumber;

    @Enumerated(EnumType.STRING) // 열거형타입을 문자그대로 저장한다.
    private AccountStatus accountStatus;

    private Long balance;

    private LocalDateTime registeredAt;
    private LocalDateTime unRegisteredAt;

    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;
}

