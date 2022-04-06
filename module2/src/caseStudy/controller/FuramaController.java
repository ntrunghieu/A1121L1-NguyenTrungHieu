package caseStudy.controller;

import caseStudy.services.Impl.BookingServiceImpl;
import caseStudy.services.Impl.CustomerServiceImpl;
import caseStudy.services.Impl.EmployeeServiceImpl;
import caseStudy.services.Impl.FacilityServiceImpl;

import java.io.IOException;
import java.util.Scanner;

public class FuramaController {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        displayMainMenu();
    }

    private static void displayMainMenu() {
        boolean check = true;
        Scanner scanner = new Scanner(System.in);

        while (check) {
            System.out.println("----------------------------");
            System.out.println("1.\tEmployee Management");
            System.out.println("2.\tCustomer Management");
            System.out.println("3.\tFacility Management ");
            System.out.println("4.\tBooking Management");
            System.out.println("5.\tPromotion Management");
            System.out.println("6.\tExit");
            System.out.println("----------------------------");
            int ip = scanner.nextInt();
            switch (ip) {
                case 1:
                    displayEmployee();
                    break;
                case 2:
                    displayCustomer();
                    break;
                case 3:
                    displayListFacility();
                    break;
                case 4:
                    displayBooking();
                    break;
                case 5:
                    displayPromotion();
                    break;
                case 6:
                    System.exit(6);
            }

        }
    }

    private static void displayEmployee() {
        boolean check = true;
        Scanner scanner = new Scanner(System.in);
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        while (check) {
            System.out.println("1. \tDisplay list employees");
            System.out.println("2. \tAdd new employee");
            System.out.println("3. \tEdit employee");
            System.out.println("4. \tDelete employee");
            System.out.println("5. \tReturn main menu");
            System.out.print("Enter number which you wanna choose: ");
            int ip = scanner.nextInt();
            switch (ip) {
                case 1:
                    employeeService.displayService();
                    break;
                case 2:
                    employeeService.addNew();
                    break;
                case 3:
                    employeeService.edit();
                    break;
                case 4:
                    employeeService.remove();
                    break;
                case 5:
                    displayMainMenu();
                    break;
            }
        }
    }

    private static void displayCustomer() {
        boolean check = true;
        Scanner scanner = new Scanner(System.in);
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        while (check) {
            System.out.println("1.\tDisplay list customers");
            System.out.println("2.\tAdd new customer");
            System.out.println("3.\tEdit customer");
            System.out.println("4. \tDelete customer");
            System.out.println("5. \tReturn main menu");
            System.out.print("Enter number which you wanna choose");
            int ip = scanner.nextInt();
            switch (ip) {
                case 1:
                    customerService.displayService();
                    break;
                case 2:
                    customerService.addNew();
                    break;
                case 3:
                    customerService.edit();
                    break;
                case 4:
                   customerService.remove();
                    break;
                case 5:
                    displayMainMenu();
                    break;
            }
        }
    }

    private static void displayListFacility() {
        boolean check = true;
        Scanner scanner = new Scanner(System.in);
        FacilityServiceImpl facilityService = new FacilityServiceImpl();
        while (check) {
            System.out.println("1. \tDisplay list facility");
            System.out.println("2. \tAdd new facility");
            System.out.println("3. \tDisplay list facility maintenance");
            System.out.println("4. \tReturn main menu");
            System.out.print("Enter number which you wanna choose: ");
            int ip = scanner.nextInt();
            switch (ip) {
                case 1:
                    facilityService.displayService();
                case 2:
                    addNewFacility();
                    break;
                case 4:
                    displayMainMenu();
                    break;
            }
        }
    }

    private static void displayBooking() {
        boolean check = true;
        Scanner scanner = new Scanner(System.in);
        BookingServiceImpl bookingService=new BookingServiceImpl();
        while (check) {
            System.out.println("1.\tAdd new booking");
            System.out.println("2.\tDisplay list booking");
            System.out.println("3.\tCreate new contracts");
            System.out.println("4.\tDisplay list contracts");
            System.out.println("5.\tEdit contracts");
            System.out.println("6.\tReturn main menu");
            System.out.print("Enter number which you wanna choose: ");
            int ip = scanner.nextInt();
            switch (ip) {
                case 1:
                    bookingService.addNew();
                    break;
                case 2:
                    bookingService.displayService();
                    break;
                case 6:
                    displayMainMenu();
                    break;
            }
        }
    }

    private static void displayPromotion() {
        boolean check = true;
        Scanner scanner = new Scanner(System.in);

        while (check) {
            System.out.println("1.\tDisplay list customers use service");
            System.out.println("2.\tDisplay list customers get voucher");
            System.out.println("3.\tReturn main menu");
            System.out.print("Enter number which you wanna choose: ");
            int ip = scanner.nextInt();
            switch (ip) {
                case 1:

                case 2:

                case 3:
                    displayMainMenu();
                    break;
            }
        }
    }

    private static void addNewFacility() {
        boolean check = true;
        Scanner scanner = new Scanner(System.in);
        FacilityServiceImpl facilityService = new FacilityServiceImpl();
        while (check) {
            System.out.println("1.\tAdd new villa");
            System.out.println("2.\tAdd new room");
            System.out.println("3.\tAdd new house");
            System.out.println("4.\tBack to menu");

            System.out.print("Enter number which you wanna choose: ");
            int ip = scanner.nextInt();
            switch (ip) {
                case 1:
                    facilityService.addNewVilla();
                    break;
                case 2:
                    facilityService.addNewRoom();
                    break;
                case 3:
                    facilityService.addNewHouse();
                    break;
                case 4:
                    displayListFacility();
                    break;
            }
        }
    }
}
