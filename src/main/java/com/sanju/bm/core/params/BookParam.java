package com.sanju.bm.core.params;

import com.sanju.bm.core.enums.Status;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class BookParam {
    private long id;

    private String name;
    private String isbn;
    private String overview;
    private Date dateOfPublish;
    private Date dateOfReprint;
    private String acknowledgement;
    private String copyright;
    private String fact;
    private String printedBy;
    private String coverDesigner;
    private String coverPhotoUrl;
    private double price;
    private List<AuthorParam> authors;
    private List<PublisherParam> publishers;
    private List<TagParam> tags;

    private String createdBy;
    private String updatedBy;
    private Status status;
}
