package model;

public class Customer {
    private int id;
    private String name;
    private String address;
    private int idCustomerType;

    public Customer() {
    }

    public Customer(String name, String address, int idCustomerType) {
        this.name = name;
        this.address = address;
        this.idCustomerType = idCustomerType;
    }

    public Customer(int id, String name, String address, int idCustomerType) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.idCustomerType = idCustomerType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getIdCustomerType() {
        return idCustomerType;
    }

    public void setIdCustomerType(int idCustomerType) {
        this.idCustomerType = idCustomerType;
    }
}
