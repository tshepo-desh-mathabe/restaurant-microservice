package dubby.serve.emailverification.domain;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Primarily to capture created and update date.
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class UserVerificationAudit {

    @Id
    @CreatedBy
    @Column(name = "FOR_USER_ID")
    @NotNull(message = "Created By Cannot Be Null")
    private Long createdBy;

    @NotNull
    @CreatedDate
    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

}
