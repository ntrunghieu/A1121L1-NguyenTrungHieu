package entity;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;

public class BlogForm {
    private Long id;
    private MultipartFile img;
    private String title;
    private String description;
    private String content;

    public BlogForm() {
    }

    public BlogForm(Long id, MultipartFile img, String title, String description, String content) {
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

    public MultipartFile getImg() {
        return img;
    }

    public void setImg(MultipartFile img) {
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
}
