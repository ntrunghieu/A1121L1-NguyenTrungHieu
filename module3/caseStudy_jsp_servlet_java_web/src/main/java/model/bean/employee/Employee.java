package model.bean.employee;

public class Employee {
    private int emId;
    private String name;
    private String birthday;
    private String idCard;
    private double price;
    private String phone;
    private String email;
    private String address;
    private int posId;
    private int eDId;
    private int division;
    private String userName;

    public Employee() {
    }

    public Employee(int emId, String name, String birthday, String idCard, double price, String phone, String email, String address, int posId, int eDId, int division, String userName) {
        this.emId = emId;
        this.name = name;
        this.birthday = birthday;
        this.idCard = idCard;
        this.price = price;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.posId = posId;
        this.eDId = eDId;
        this.division = division;
        this.userName = userName;
    }

    public int getEmId() {
        return emId;
    }

    public void setEmId(int emId) {
        this.emId = emId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPosId() {
        return posId;
    }

    public void setPosId(int posId) {
        this.posId = posId;
    }

    public int geteDId() {
        return eDId;
    }

    public void seteDId(int eDId) {
        this.eDId = eDId;
    }

    public int getDivision() {
        return division;
    }

    public void setDivision(int division) {
        this.division = division;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
