package model.bean.employee;

public class Level {
    private int idLevel;
    private String nameLevel;

    public Level() {
    }

    public Level(int idLevel, String nameLevel) {
        this.idLevel = idLevel;
        this.nameLevel = nameLevel;
    }

    public int getIdLevel() {
        return idLevel;
    }

    public void setIdLevel(int idLevel) {
        this.idLevel = idLevel;
    }

    public String getNameLevel() {
        return nameLevel;
    }

    public void setNameLevel(String nameLevel) {
        this.nameLevel = nameLevel;
    }
}
