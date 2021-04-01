package dubby.serve.service.update.accountupdate.audit;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Primarily to capture created and update date.
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class DateAudit {

    @CreatedDate
    @Column(name = "CREATED_AT")
    @NotNull(message = "Created At Date Cannot Be Null")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "UPDATED_AT")
    private LocalDateTime updatedAt;

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @PrePersist
    protected void beforePersistingCreatedAt() {
        if (createdAt == null ) createdAt = LocalDateTime.now();
    }
}
