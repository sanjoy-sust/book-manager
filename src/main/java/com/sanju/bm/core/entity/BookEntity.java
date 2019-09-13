package com.sanju.bm.core.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity(name = "book")
public class BookEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "overview")
    private String overview;

    @Column(name = "date_of_publish")
    private Date dateOfPublish;

    @Column(name = "date_of_repring")
    private Date dateOfReprint;

    @Column(name = "acknowledgement")
    private String acknowledgement;

    @Column(name = "copyright")
    private String copyright;

    @Column(name = "fact")
    private String fact;

    @Column(name = "printed_by")
    private String printedBy;

    @Column(name = "cover_designer")
    private String coverDesigner;

    @Column(name = "cover_photo_url")
    private String coverPhotoUrl;

    @Column(name = "price")
    private double price;

    @ManyToMany
    @JoinTable(
            name = "book_publisher",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "publisher_id"))
    private List<PublisherEntity> publishers;

    @ManyToMany
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<AuthorEntity> authors;

    @ManyToMany
    @JoinTable(
            name = "book_tag",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<TagEntity> tags;

}
