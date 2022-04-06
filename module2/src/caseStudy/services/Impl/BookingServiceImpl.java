package caseStudy.services.Impl;

import caseStudy.models.Booking;
import caseStudy.models.Customer;
import caseStudy.models.Facility;
import caseStudy.models.Villa;
import caseStudy.services.BookingService;
import caseStudy.utils.BookingComparator;
import caseStudy.utils.WriteReadFile;

import java.awt.print.Book;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class BookingServiceImpl implements BookingService {
    static Scanner scanner = new Scanner(System.in);

    static WriteReadFile writeReadFile=new WriteReadFile();

    private final String path="D:\\CODE\\A1121L1-NguyenTrungHieu\\module2\\src\\caseStudy\\data\\facility.csv";

    static Set<Booking> bookingSet = new TreeSet<>(new BookingComparator());

    static List<Customer> customerList = new ArrayList<>();

    static Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<Facility, Integer>();

    static {
        System.out.println("----------- BOOKING MANAGEMENT INFORMATION -------------");
//        customerList.add(new Customer("hieu",1132,"09123","hieu123@",
//                "nam","hieupro132","vjp","ngo quyen"));
//        customerList.add(new Customer("khai",3122,"094","khai321@",
//                "nu","khaingok33","bth","ngo quyen"));
//        customerList.add(new Customer("trung",3243,"31314","trunghe23@",
//                "nu","trungga99","ngheo","hai chau"));
//        try (BufferedReader reader = new BufferedReader(new FileReader("D:\\CODE\\A1121L1-NguyenTrungHieu\\module2\\src\\customer.txt"));) {
//            String line=null;
//            line=reader.readLine();
//            while ((line = reader.readLine()) != null){
//                System.out.println(line);
//
//            }
//            reader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        facilityIntegerMap.put(new Villa("vl01", "230m2", 1000, 5,
                "thang", "vjp", "40", 4), 0);
        facilityIntegerMap.put(new Villa("vl03", "77m2", 2000, 15,
                "ngay", "vjp", "34", 3), 0);
        facilityIntegerMap.put(new Villa("vl33", "100m2", 2500, 20,
                "nam", "vjp", "23", 2), 0);


    }


    @Override
    public void displayService() {
        facilityIntegerMap= (Map<Facility, Integer>) writeReadFile.readToFile(path);
        for (Booking booking : bookingSet) {
            System.out.println(booking.toString());
        }
    }

    @Override
    public void addNew() {
        int id = 1;
        if (!bookingSet.isEmpty()) {
            id = bookingSet.size();
        }
        Customer customer = chooseCustomer();
        Facility facility = chooseFacility();
        System.out.println("Start date: ");
        String startDate = scanner.nextLine();
        System.out.println("End date: ");
        String endDate = scanner.nextLine();

        Booking booking = new Booking(id, startDate, endDate, customer, facility);

        bookingSet.add(booking);
        writeReadFile.writeToFile(bookingSet,path);
        System.out.println("Congratulations on your successful booking");

    }

    @Override
    public void edit() {

    }

    @Override
    public void remove() {

    }

    public static Customer chooseCustomer() {
        String pathCustomer="D:\\CODE\\A1121L1-NguyenTrungHieu\\module2\\src\\caseStudy\\data\\customer.csv";
        System.out.println("List the customer");
//        try (BufferedReader reader = new BufferedReader(new FileReader("D:\\CODE\\A1121L1-NguyenTrungHieu\\module2\\src\\customer.txt"));) {
//            String line=null;
////            line=reader.readLine();
//            while ((line = reader.readLine()) != null){
//                System.out.println(line);
//
//            }
//            reader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        for (Customer i : customerList) {
//            System.out.println(i.toString());
//        }
        customerList= (List<Customer>) writeReadFile.readToFile(pathCustomer);
        for (Customer i: customerList) {
            System.out.println(i.toString());
        }
        System.out.println("Enter the ID Customer: ");
        String idCustomer = scanner.nextLine();
        boolean check = true;
        while (true) {
            for (Customer customer : customerList) {
                if (idCustomer.equals(customer.IDCustomer)) {
                    check = false;
                    return customer;
                }
            }
            if (check) {
                System.out.println("khong tim thay " + idCustomer + ". Vui long nhap lai: ");
                idCustomer = scanner.nextLine();
            }
        }

    }

    public static Facility chooseFacility() {
        String pathFacility="D:\\CODE\\A1121L1-NguyenTrungHieu\\module2\\src\\caseStudy\\data\\facility.csv";
        System.out.println("List the facility");
        facilityIntegerMap= writeReadFile.readToFile1(pathFacility);
//        for (Booking booking : bookingSet) {
//            System.out.println(booking.toString());
//        }
        for (Map.Entry<Facility, Integer> i : facilityIntegerMap.entrySet()) {
            System.out.println(i.toString());
        }
        System.out.println("Enter the name Facility: ");
        String idService = scanner.nextLine();
        boolean check = true;
        while (true) {
            for (Map.Entry<Facility, Integer> i : facilityIntegerMap.entrySet()) {
                if (idService.equals(i.getKey().nameService)) {
                    check = false;
                    return i.getKey();
                }
            }
            if (check) {
                System.out.println("khong tim thay " + idService + ". Vui long nhap lai: ");
                idService = scanner.nextLine();
            }
        }

    }
}
