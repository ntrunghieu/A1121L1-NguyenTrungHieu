package caseStudy.services.Impl;

import caseStudy.models.*;
import caseStudy.services.FacilityService;
import caseStudy.utils.RegexData;
import caseStudy.utils.WriteReadFileBinary;

import java.util.*;

public class FacilityServiceImpl implements FacilityService {
    static Scanner scanner = new Scanner(System.in);

    public static final String REGEX_STR="^[A-Z][a-z4-50]+$";
    public static final String REGEX_ID_VILLA="(SVVL)-[//d]{4}";
    public static final String REGEX_ID_HOUSE="(SVHO)-[//d]{4}";
    public static final String REGEX_ID_ROOM="(SVRO)-[//d]{4}";
    public static final String REGEX_AREA="^({3,9})\\d|[1-9]\\d{2,}$";
    public static final String REGEX_INT="^[1-9]|([1][0-9])$";
    public static final String REGEX_AMOUNT="^[1-9]|([1][0-9])|(20)$";

    static List<Villa> villaArrayList = new ArrayList<>();
    static List<Room> roomArrayList = new ArrayList<>();
    static List<House> houseArrayList = new ArrayList<>();
    static Map<Facility,Integer> facilityIntegerMap=new LinkedHashMap<Facility,Integer>();
    static WriteReadFileBinary writeReadFileBinary =new WriteReadFileBinary();

    private final String path="D:\\CODE\\A1121L1-NguyenTrungHieu\\module2\\src\\caseStudy\\data\\villa.csv";
    private final String path1="D:\\CODE\\A1121L1-NguyenTrungHieu\\module2\\src\\caseStudy\\data\\room.csv";
    private final String path2="D:\\CODE\\A1121L1-NguyenTrungHieu\\module2\\src\\caseStudy\\data\\house.csv";

    public Villa getVilla(){
        System.out.println("------ ADD NEW VILLA ---------");


        String nameService = inputName();

        String areaRoom = inputArea();

        String inputFee=inputFee();

        String maxPeople = inputAmountPeople();

        String rentalType = inputRentalType();

        String standard = inputStandard();

        String poolArea = inputPool();

        String floor = inputFloor();

        return new Villa(nameService,areaRoom,inputFee,maxPeople,rentalType,standard,poolArea,floor);
    }
    private String inputName(){
        System.out.println("Name Service : ");
        return RegexData.regexStr(scanner.nextLine(),REGEX_STR,"capitalize first letter. Enter again!: ");
    }
    private String inputRentalType(){
        System.out.println("Rental type: ");
        return RegexData.regexStr(scanner.nextLine(),REGEX_STR,"capitalize first letter. Enter again!: ");
    }
    private String inputStandard(){
        System.out.println("Standard room: ");
        return RegexData.regexStr(scanner.nextLine(),REGEX_STR,"capitalize first letter. Enter again!: ");
    }
    private String inputArea(){
        System.out.println("Area room: ");
        return RegexData.regexStr(scanner.nextLine(),REGEX_AREA,"Must be bigger 30. Enter again!: ");
    }
    private String inputPool(){
        System.out.println("Pool area: ");
        return RegexData.regexStr(scanner.nextLine(),REGEX_AREA,"Must be bigger 30. Enter again!: ");
    }
    private String inputFee(){
        System.out.println("Rental fee: ");
        return RegexData.regexStr(scanner.nextLine(),REGEX_INT,"Must be bigger 0. Enter again!: ");
    }
    private String inputFloor(){
        System.out.println("Floor number: ");
        return RegexData.regexStr(scanner.nextLine(),REGEX_INT,"Must be bigger 0. Enter again!: ");
    }
    private String inputAmountPeople(){
        System.out.println("Maximum people: ");
        return RegexData.regexStr(scanner.nextLine(),REGEX_AMOUNT,"Must be < 0 && < 20. Enter again: ");
    }
    public Room getRoom(){
        System.out.println("------ ADD NEW ROOM ---------");
        String nameService=scanner.nextLine();;
        System.out.println("Area room: ");
        String areaRoom = scanner.nextLine();
        System.out.println("Rental fee: ");
        String inputFee=scanner.nextLine();
        System.out.println("Maximum people: ");
        String maxPeople = scanner.nextLine();
        System.out.println("Rental type: ");
        String rentalType = scanner.nextLine();
        System.out.println("Free service: ");
        String freeService = scanner.nextLine();

        return new Room(nameService,areaRoom,inputFee,maxPeople,rentalType,freeService);
    }
    public House getHouse(){
        System.out.println("------ ADD NEW HOUSE ---------");
        System.out.println("Name Service: ");
        String nameService = scanner.nextLine();
        System.out.println("Area room: ");
        String areaRoom = scanner.nextLine();
        System.out.println("Rental fee: ");
        String fee = scanner.nextLine();
        System.out.println("Maximum people: ");
        String maxPeople = scanner.nextLine();
        System.out.println("Rental type: ");
        String rentalType = scanner.nextLine();
        System.out.println("Standard room: ");
        String standard = scanner.nextLine();
        System.out.println("Floor number: ");
        String floor = scanner.nextLine();

        return new House(nameService,areaRoom,fee,maxPeople,rentalType,standard,floor);
    }
    @Override
    public void displayService() {
        villaArrayList= (List<Villa>) writeReadFileBinary.readToFile(path);
        roomArrayList= (List<Room>) writeReadFileBinary.readToFile(path1);

        houseArrayList= (List<House>) writeReadFileBinary.readToFile(path2);

        for (Villa villa: villaArrayList) {
            System.out.println(villa.toString());
        }
        for (Room room: roomArrayList) {
            System.out.println(room.toString());
        }
        for (House house: houseArrayList) {
            System.out.println(house.toString());
        }
//        facilityIntegerMap= (Map<Facility, Integer>) writeReadFileBinary.readToFile1(path);
//        for (Map.Entry<Facility, Integer> villa: facilityIntegerMap.entrySet()) {
//            System.out.println(villa.getKey()+" Times: "+villa.getValue());
//        }

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
        villaArrayList.add(villa);
        writeReadFileBinary.writeToFile(villaArrayList,path);
        System.out.println("Congratulations. Thanks for believe in");
    }

    @Override
    public void addNewRoom() {
        Room room=getRoom();
        facilityIntegerMap.put(room,0);
        roomArrayList.add(room);
        writeReadFileBinary.writeToFile(roomArrayList,path1);
//        writeReadFileBinary.writeToFile1( facilityIntegerMap,path);
        System.out.println("Congratulations. Thanks for believe in");

    }

    @Override
    public void addNewHouse() {
        House house=getHouse();
        facilityIntegerMap.put(house,0);
        houseArrayList.add(house);
        writeReadFileBinary.writeToFile(houseArrayList,path2);
//        writeReadFileBinary.writeToFile1(facilityIntegerMap,path);
        System.out.println("Congratulations. Thanks for believe in");

    }
}
