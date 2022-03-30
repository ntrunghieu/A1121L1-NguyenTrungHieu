package caseStudy.models;

public abstract class Facility {
    public String nameService;
    public String areaRoomToUse;
    public double rentalFee;
    public int maxPeople;
    public String rentalType;

    public Facility() {
    }

    public Facility(String nameService, String areaRoomToUse, double rentalFee, int maxPeople, String rentalType) {
        this.nameService = nameService;
        this.areaRoomToUse = areaRoomToUse;
        this.rentalFee = rentalFee;
        this.maxPeople = maxPeople;
        this.rentalType = rentalType;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public String getAreaRoomToUse() {
        return areaRoomToUse;
    }

    public void setAreaRoomToUse(String areaRoomToUse) {
        this.areaRoomToUse = areaRoomToUse;
    }

    public double getRentalFee() {
        return rentalFee;
    }

    public void setRentalFee(double rentalFee) {
        this.rentalFee = rentalFee;
    }

    public double getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }
}
