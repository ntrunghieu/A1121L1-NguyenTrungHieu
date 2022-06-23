package model.bean;

public class Category {
    private int maCategory;
    private String tenCategory;

    public Category() {
    }

    public Category(int maCategory, String tenCategory) {
        this.maCategory = maCategory;
        this.tenCategory = tenCategory;
    }

    public int getMaCategory() {
        return maCategory;
    }

    public void setMaCategory(int maCategory) {
        this.maCategory = maCategory;
    }

    public String getTenCategory() {
        return tenCategory;
    }

    public void setTenCategory(String tenCategory) {
        this.tenCategory = tenCategory;
    }
}
