package dubby.serve.emailverification.dto;

import java.time.LocalDateTime;

public abstract class UserVerificationAuditDto {

    private LocalDateTime createdAtDate;
    private Long createdByUserId;

    public LocalDateTime getCreatedAtDate() {
        return createdAtDate;
    }

    public void setCreatedAtDate(LocalDateTime createdAtDate) {
        this.createdAtDate = createdAtDate;
    }

    public Long getCreatedByUserId() {
        return createdByUserId;
    }

    public void setCreatedByUserId(Long createdByUserId) {
        this.createdByUserId = createdByUserId;
    }
}
