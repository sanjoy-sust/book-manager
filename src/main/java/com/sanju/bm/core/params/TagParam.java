package com.sanju.bm.core.params;

import com.sanju.bm.core.enums.Status;
import lombok.Data;

@Data
public class TagParam {
    private long id;
    private String name;
    private String category;
    private Status status;
    private String createdBy;
    private String updatedBy;
}
