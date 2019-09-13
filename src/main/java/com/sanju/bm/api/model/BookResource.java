package com.sanju.bm.api.model;

import com.sanju.bm.core.enums.Status;
import com.sanju.bm.core.params.AuthorParam;
import com.sanju.bm.core.params.PublisherParam;
import com.sanju.bm.core.params.TagParam;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class BookResource {
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
    private List<AuthorResource> authors;
    private List<PublisherResource> publishers;
    private List<TagResource> tags;

    private String createdBy;
    private String updatedBy;
}
