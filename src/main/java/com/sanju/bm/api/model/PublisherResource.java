package com.sanju.bm.api.model;

import lombok.Data;

@Data
public class PublisherResource {
    private long id;
    private String name;
    private String address;
    private String mobile;
    private String contactPersonName;
    private String contactPersonMobile;
    private String website;
    private String email;
    private String facebookPage;
    private String about;
    private String background;
    private String createdBy;
    private String updatedBy;
}
