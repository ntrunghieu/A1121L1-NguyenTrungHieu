package caseStudy.models;

public class Villa extends Facility{
    private String standardRoom;
    private String PoolArea;
    private int floorNumber;

    public Villa() {
    }

    public Villa(String nameService, String areaRoomToUse, double rentalFee, int maxPeople, String rentalType, String standardRoom, String poolArea, int floorNumber) {
        super(nameService, areaRoomToUse, rentalFee, maxPeople, rentalType);
        this.standardRoom = standardRoom;
        this.PoolArea = poolArea;
        this.floorNumber = floorNumber;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getPoolArea() {
        return PoolArea;
    }

    public void setPoolArea(String poolArea) {
        PoolArea = poolArea;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    @Override
    public String toString() {
        return "Villa{" +
                "standardRoom='" + standardRoom + '\'' +
                ", PoolArea='" + PoolArea + '\'' +
                ", floorNumber=" + floorNumber +
                ", nameService='" + nameService + '\'' +
                ", areaRoomToUse='" + areaRoomToUse + '\'' +
                ", rentalFee=" + rentalFee +
                ", maxPeople=" + maxPeople +
                ", rentalType=" + rentalType +
                '}';
    }
}
