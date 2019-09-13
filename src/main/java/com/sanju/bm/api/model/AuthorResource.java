package com.sanju.bm.api.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
public class AuthorResource {
    private long id;
    private String name;
    private String email;
    private String mobile;
    private String address;
    private Date birthDate;
    private String country;
    private String biography;
    private String background;
    private String nickname;
    private String createdBy;
    private String updatedBy;
    private String photoUrl;
}
