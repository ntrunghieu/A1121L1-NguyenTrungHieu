package caseStudy.models;

public class House extends Facility{
    private  String standardRoom;
    private int floorNumber;

    public House() {
    }

    public House(String nameService, String areaRoomToUse, double rentalFee, int maxPeople, String rentalType, String standardRoom, int floorNumber) {
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

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
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
