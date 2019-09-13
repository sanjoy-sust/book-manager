package com.sanju.bm.core.entity;

import com.sanju.bm.core.enums.Status;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper=true)
@Entity(name = "author")
public class AuthorEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "address")
    private String address;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "birthdate")
    private Date birthDate;

    @Column(name = "country")
    private String country;

    @Column(name = "biography")
    private String biography;

    @Column(name = "background")
    private String background;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "photo_url")
    private String photoUrl;

    @ManyToMany(mappedBy = "authors")
    private List<BookEntity> books;

}
