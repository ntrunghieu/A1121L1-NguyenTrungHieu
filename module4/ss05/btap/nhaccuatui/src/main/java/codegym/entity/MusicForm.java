package codegym.entity;

public class MusicForm {
    private Integer id;
    private String name;
    private String artist;
    private String type;
    private String link;

    public MusicForm() {
    }

    public MusicForm(Integer id, String name, String artist, String type, String link) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.type = type;
        this.link = link;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
