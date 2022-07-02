package entity;

public class Email {
    private String language;
    private String pageSize;
    private String signature;

    public Email(){}

    public Email(String language, String pageSize, String signature) {
        this.language = language;
        this.pageSize = pageSize;
        this.signature = signature;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
