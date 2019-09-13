package com.sanju.bm.core.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity(name = "publisher")
public class PublisherEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "contact_person_name")
    private String contactPersonName;

    @Column(name = "contact_person_mobile")
    private String contactPersonMobile;

    @Column(name = "website")
    private String website;

    @Column(name = "email")
    private String email;

    @Column(name = "facebook_page")
    private String facebookPage;

    @Column(name = "about")
    private String about;

    @Column(name = "background")
    private String background;

    @Column(name = "photo_url")
    private String photoUrl;

    @ManyToMany(mappedBy = "publishers")
    private List<BookEntity> books;
}
