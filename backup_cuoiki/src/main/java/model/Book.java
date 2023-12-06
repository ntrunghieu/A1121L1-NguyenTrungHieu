package model;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @Column(name="book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    @Column(name="book_code")
    private String bookCode;

    @Column(name="book_name")
    private String bookName;

    @Column(name="book_image")
    private String bookImage;

    @Column(name="book_content")
    private String bookContent;

    @Column(name="book_status")
    private Boolean bookStatus = false;

    @Column(name="book_price")
    private Double bookPrice;

    @Column(name="book_translator")
    private String bookTranslator;

    @Column(name="book_quantity")
    private Integer bookQuantity=0;

    @Column(name="book_flag")
    private Boolean bookFlag=false;

    @Column(name="book_publisher")
    private String bookPublisher;

    @Column(name="book_author")
    private String bookAuthor;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_category_id")
    private Category bookCategoryId;

    public Book() {
    }

    public Book(Long bookId, String bookCode, String bookName, String bookImage, String bookContent, Boolean bookStatus, Double bookPrice, String bookTranslator, Integer bookQuantity, Boolean bookFlag, String bookPublisher, String bookAuthor, Category bookCategoryId) {
        this.bookId = bookId;
        this.bookCode = bookCode;
        this.bookName = bookName;
        this.bookImage = bookImage;
        this.bookContent = bookContent;
        this.bookStatus = bookStatus;
        this.bookPrice = bookPrice;
        this.bookTranslator = bookTranslator;
        this.bookQuantity = bookQuantity;
        this.bookFlag = bookFlag;
        this.bookPublisher = bookPublisher;
        this.bookAuthor = bookAuthor;
        this.bookCategoryId = bookCategoryId;
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

    public Category getBookCategoryId() {
        return bookCategoryId;
    }

    public void setBookCategoryId(Category bookCategoryId) {
        this.bookCategoryId = bookCategoryId;
    }

    @Override
    public String toString() {
        return this.bookName;
    }
}

