package com.codegym.demo.entity.book;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    private String bookCode;

    private String bookName;

    private String bookImage;

    private String bookContent;

    private Boolean bookStatus = false;

    private Double bookPrice;

    private String bookTranslator;

    private Integer bookWeight;

    private LocalDate bookPublishDate;

    private Integer bookQuantity=0;

    private Boolean bookFlag=false;

    private String bookPublisher;

    private String bookAuthor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_category_id")
    private BookCategory bookCategoryId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_promotion_id")
    private Promotion bookPromotionId;

    public Book() {
    }

    public Book(Long bookId, String bookCode, String bookName, String bookImage, String bookContent, Boolean bookStatus, Double bookPrice, String bookTranslator, Integer bookWeight, LocalDate bookPublishDate, Integer bookQuantity, Boolean bookFlag, String bookPublisher, String bookAuthor, BookCategory bookCategoryId, Promotion bookPromotionId) {
        this.bookId = bookId;
        this.bookCode = bookCode;
        this.bookName = bookName;
        this.bookImage = bookImage;
        this.bookContent = bookContent;
        this.bookStatus = bookStatus;
        this.bookPrice = bookPrice;
        this.bookTranslator = bookTranslator;
        this.bookWeight = bookWeight;
        this.bookPublishDate = bookPublishDate;
        this.bookQuantity = bookQuantity;
        this.bookFlag = bookFlag;
        this.bookPublisher = bookPublisher;
        this.bookAuthor = bookAuthor;
        this.bookCategoryId = bookCategoryId;
        this.bookPromotionId = bookPromotionId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookImage() {
        return bookImage;
    }

    public void setBookImage(String bookImage) {
        this.bookImage = bookImage;
    }

    public String getBookContent() {
        return bookContent;
    }

    public void setBookContent(String bookContent) {
        this.bookContent = bookContent;
    }

    public Boolean getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(Boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    public Double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookTranslator() {
        return bookTranslator;
    }

    public void setBookTranslator(String bookTranslator) {
        this.bookTranslator = bookTranslator;
    }

    public Integer getBookWeight() {
        return bookWeight;
    }

    public void setBookWeight(Integer bookWeight) {
        this.bookWeight = bookWeight;
    }

    public LocalDate getBookPublishDate() {
        return bookPublishDate;
    }

    public void setBookPublishDate(LocalDate bookPublishDate) {
        this.bookPublishDate = bookPublishDate;
    }

    public Integer getBookQuantity() {
        return bookQuantity;
    }

    public void setBookQuantity(Integer bookQuantity) {
        this.bookQuantity = bookQuantity;
    }

    public Boolean getBookFlag() {
        return bookFlag;
    }

    public void setBookFlag(Boolean bookFlag) {
        this.bookFlag = bookFlag;
    }

    public String getBookPublisher() {
        return bookPublisher;
    }

    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public BookCategory getBookCategoryId() {
        return bookCategoryId;
    }

    public void setBookCategoryId(BookCategory bookCategoryId) {
        this.bookCategoryId = bookCategoryId;
    }

    public Promotion getBookPromotionId() {
        return bookPromotionId;
    }

    public void setBookPromotionId(Promotion bookPromotionId) {
        this.bookPromotionId = bookPromotionId;
    }
}
