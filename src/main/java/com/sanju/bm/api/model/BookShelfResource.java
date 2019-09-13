package com.sanju.bm.api.model;

import com.sanju.bm.core.enums.Status;
import lombok.Data;

@Data
public class BookShelfResource {
    private long id;
    private String name;
    private String category;
    private long capability;
    private Status status;
    private String createdBy;
    private String updatedBy;
}
