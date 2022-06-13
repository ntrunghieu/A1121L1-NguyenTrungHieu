package model.bean.service;

public class Service {
    private int serId;
    private String serName;
    private int area;
    private double cost;
    private int maxPeople;
    private int rentType;
    private int serviceType;
    private String standard;
    private String description;
    private double poolArea;
    private int numOfFloor;

    public Service() {
    }

    public Service(int serId, String serName, int area, double cost, int maxPeople, int rentType, String standard, String description, double poolArea, int numOfFloor) {
        this.serId = serId;
        this.serName = serName;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.rentType = rentType;
        this.standard = standard;
        this.description = description;
        this.poolArea = poolArea;
        this.numOfFloor = numOfFloor;
    }

    public Service(int serId, String serName, int area, double cost, int maxPeople, int rentType, int serviceType, String standard, String description, double poolArea, int numOfFloor) {
        this.serId = serId;
        this.serName = serName;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.rentType = rentType;
        this.serviceType = serviceType;
        this.standard = standard;
        this.description = description;
        this.poolArea = poolArea;
        this.numOfFloor = numOfFloor;
    }

    public int getSerId() {
        return serId;
    }

    public void setSerId(int serId) {
        this.serId = serId;
    }

    public String getSerName() {
        return serName;
    }

    public void setSerName(String serName) {
        this.serName = serName;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public int getRentType() {
        return rentType;
    }

    public void setRentType(int rentType) {
        this.rentType = rentType;
    }

    public int getServiceType() {
        return serviceType;
    }

    public void setServiceType(int serviceType) {
        this.serviceType = serviceType;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(int poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumOfFloor() {
        return numOfFloor;
    }

    public void setNumOfFloor(int numOfFloor) {
        this.numOfFloor = numOfFloor;
    }
}
