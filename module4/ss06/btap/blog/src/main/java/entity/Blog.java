package entity;

import javax.persistence.*;

@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String img;
    private String title;
    @Column(length = 300)
    private String description;
    @Column(columnDefinition = "TEXT")
    private String content;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Blog(String img, String title, String description, String content) {
        this.img = img;
        this.title = title;
        this.description = description;
        this.content = content;
    }

    public Blog(Long id, String img, String title, String description, String content, Category category) {
        this.id = id;
        this.img = img;
        this.title = title;
        this.description = description;
        this.content = content;
        this.category = category;
    }

    public Blog() {

    }

    public Blog(Long id, String img, String title, String description, String content) {
        this.id = id;
        this.img = img;
        this.title = title;
        this.description = description;
        this.content = content;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
