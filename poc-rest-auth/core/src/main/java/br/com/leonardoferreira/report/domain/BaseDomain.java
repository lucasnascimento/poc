package br.com.leonardoferreira.report.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@MappedSuperclass
public class BaseDomain {
    @JsonFormat(pattern = "dd/MM/yyyy kk:mm")
    protected LocalDateTime createdAt;

    @JsonFormat(pattern = "dd/MM/yyyy kk:mm")
    protected LocalDateTime updatedAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

}
