package caseStudy.services.Impl;

import caseStudy.models.Facility;
import caseStudy.models.House;
import caseStudy.models.Room;
import caseStudy.models.Villa;
import caseStudy.services.FacilityService;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FacilityServiceImpl implements FacilityService {
    static Scanner scanner = new Scanner(System.in);
    static Map<Facility,Integer> facilityIntegerMap=new LinkedHashMap<Facility,Integer>();

    public Villa getVilla(){
        System.out.println("------ ADD NEW VILLA ---------");

        System.out.println("Name Service: ");
        String nameService = scanner.nextLine();
        System.out.println("Area room: ");
        String areaRoom = scanner.nextLine();
        System.out.println("Rental fee: ");
        String inputFee=scanner.nextLine();
        double fee = Double.parseDouble(inputFee);
        System.out.println("Maximum people: ");
        int maxPeople = Integer.parseInt(scanner.nextLine());
        System.out.println("Rental type: ");
        String rentalType = scanner.nextLine();
        System.out.println("Standard room: ");
        String standard = scanner.nextLine();
        System.out.print("Pool area: ");
        String poolArea = scanner.nextLine();
        System.out.println("Floor number: ");
        int floor = Integer.parseInt(scanner.nextLine());

        return new Villa(nameService,areaRoom,fee,maxPeople,rentalType,standard,poolArea,floor);
    }
    public Room getRoom(){
        System.out.println("------ ADD NEW ROOM ---------");

        System.out.println("Name Service: ");
        String nameService = scanner.nextLine();
        System.out.println("Area room: ");
        String areaRoom = scanner.nextLine();
        System.out.println("Rental fee: ");
        String inputFee=scanner.nextLine();
        double fee = Double.parseDouble(inputFee);
        System.out.println("Maximum people: ");
        int maxPeople = Integer.parseInt(scanner.nextLine());
        System.out.println("Rental type: ");
        String rentalType = scanner.nextLine();
        System.out.println("Free service: ");
        String freeService = scanner.nextLine();

        return new Room(nameService,areaRoom,fee,maxPeople,rentalType,freeService);
    }
    public House getHouse(){
        System.out.println("------ ADD NEW HOUSE ---------");

        System.out.println("Name Service: ");
        String nameService = scanner.nextLine();
        System.out.println("Area room: ");
        String areaRoom = scanner.nextLine();
        System.out.println("Rental fee: ");
        String inputFee=scanner.nextLine();
        double fee = Double.parseDouble(inputFee);
        System.out.println("Maximum people: ");
        int maxPeople = Integer.parseInt(scanner.nextLine());
        System.out.println("Rental type: ");
        String rentalType = scanner.nextLine();
        System.out.println("Standard room: ");
        String standard = scanner.nextLine();
        System.out.println("Floor number: ");
        int floor = Integer.parseInt(scanner.nextLine());

        return new House(nameService,areaRoom,fee,maxPeople,rentalType,standard,floor);
    }
    @Override
    public void displayService() {
        for (Map.Entry<Facility, Integer> villa: facilityIntegerMap.entrySet()) {
            System.out.println(villa.getKey()+" Times: "+villa.getValue());
        }

    }

    @Override
    public void addNew() {


    }

    @Override
    public void edit() {

    }

    @Override
    public void remove() {

    }

    @Override
    public void display() {

    }

    @Override
    public void addNewVilla() {
        Villa villa=getVilla();
        facilityIntegerMap.put(villa,0);
        System.out.println("Congratulations. Thanks for believe in");
    }

    @Override
    public void addNewRoom() {
        Room room=getRoom();
        facilityIntegerMap.put(room,0);
        System.out.println("Congratulations. Thanks for believe in");

    }

    @Override
    public void addNewHouse() {
        House house=getHouse();
        facilityIntegerMap.put(house,0);
        System.out.println("Congratulations. Thanks for believe in");

    }
}
