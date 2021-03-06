package uz.ssd.locationsender.domain.entity.locsender.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @JsonFormat(pattern="dd.MM.yyyy HH:mm:ss")
    @CreatedDate
    @Column(name = "created_date")
    private Date createdDate;

    @JsonFormat(pattern="dd.MM.yyyy HH:mm:ss")
    @LastModifiedDate
    @Column(name = "updated_date")
    private Date updatedDate;

    private boolean active;

}
