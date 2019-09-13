package com.sanju.bm.core.entity;

import com.sanju.bm.core.enums.Status;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Data
public abstract class BaseEntity implements Serializable {
    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_by")
    private String updatedBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created")
    private Date created;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated")
    private Date updated;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;



    @PrePersist
    protected void onCreate(){
        created = new Date();
    }

    @PreUpdate
    protected void onUpdate(){
        updated = new Date();
    }
}
