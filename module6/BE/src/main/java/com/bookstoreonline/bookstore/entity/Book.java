package com.bookstoreonline.bookstore.entity;

import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "book")
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "sku")
    private String sku;
    @Column(name = "name")
    private String name;
    @Column(name = "author")
    private String author;
    @Column(name = "publisher")
    private String publisher;
    @Column(name = "description")
    private String description;
    @Column(name = "unit_price")
    private BigDecimal unitPrice;
    @Column(name = "page")
    private String page;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "date_created")
    @UpdateTimestamp
    private Date dateCreated;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private BookCategory category;
}
