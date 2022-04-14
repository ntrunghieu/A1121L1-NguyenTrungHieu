package caseStudy.models;

public class House extends Facility{
    private  String standardRoom;
    private String floorNumber;

    public House() {
    }

    public House(String nameService, String areaRoomToUse, String rentalFee, String maxPeople, String rentalType, String standardRoom, String floorNumber) {
        super(nameService, areaRoomToUse, rentalFee, maxPeople, rentalType);
        this.standardRoom = standardRoom;
        this.floorNumber = floorNumber;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(String floorNumber) {
        this.floorNumber = floorNumber;
    }

    @Override
    public String toString() {
        return "House{" +
                "standardRoom='" + standardRoom + '\'' +
                ", floorNumber=" + floorNumber +
                ", nameService='" + nameService + '\'' +
                ", areaRoomToUse='" + areaRoomToUse + '\'' +
                ", rentalFee=" + rentalFee +
                ", maxPeople=" + maxPeople +
                ", rentalType='" + rentalType + '\'' +
                '}';
    }
}
