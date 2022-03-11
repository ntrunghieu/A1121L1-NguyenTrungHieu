package caseStudy.controller;

import java.io.IOException;
import java.util.Scanner;

public class FuramaController {
    public static void main(String[] args) throws IOException {
        Scanner scanner=new Scanner(System.in);
        returnMenu(scanner);
    }

    private static void returnMenu(Scanner scanner) {
        int choice=-1;
        System.out.println("----------------------------");
        System.out.println("1.\tEmployee Management");
        System.out.println("2.\tCustomer Management");
        System.out.println("3.\tFacility Management ");
        System.out.println("4.\tBooking Managerment");
        System.out.println("5.\tPromotion Management");
        System.out.println("6.\tExit");
        System.out.println("----------------------------");
        while (choice!=6){

            choice=scanner.nextInt();
            displayMenu(choice);

        }
    }

    private static void displayMenu(int choice) {
        Scanner scanner=new Scanner(System.in);
        int numbers;
        switch (choice){
            case 1:
                System.out.println("1. \tDisplay list employees");
                System.out.println("2. \tAdd new employee");
                System.out.println("3. \tEdit employee");
                System.out.println("4. \tReturn main menu");
                System.out.println("Enter number which you wanna choose");
                 numbers=scanner.nextInt();
                switch (numbers){
                    case 4:
                        returnMenu(scanner);
                        break;
                }
                break;
            case 2:
                System.out.println("1.\tDisplay list customers");
                System.out.println("2.\tAdd new customer");
                System.out.println("3.\tEdit customer");
                System.out.println("4.\tReturn main menu");
                System.out.print("Enter number which you wanna choose");
                numbers=scanner.nextInt();
                switch (numbers){
                    case 4:
                        returnMenu(scanner);
                        break;
                }
                break;
            case 3:
                System.out.println("1. \tDisplay list facility");
                System.out.println("2. \tAdd new facility");
                System.out.println("3. \tDisplay list facility maintenance");
                System.out.println("4. \tReturn main menu");
                System.out.print("Enter number which you wanna choose");
                numbers=scanner.nextInt();
                switch (numbers){
                    case 4:
                        returnMenu(scanner);
                        break;
                }
                break;
            case 4:
                System.out.println("1.\tAdd new booking");
                System.out.println("2.\tDisplay list booking");
                System.out.println("3.\tCreate new constracts");
                System.out.println("4.\tDisplay list contracts");
                System.out.println("5.\tEdit contracts");
                System.out.println("6.\tReturn main menu");
                System.out.print("Enter number which you wanna choose");
                numbers=scanner.nextInt();
                switch (numbers){
                    case 6:
                        returnMenu(scanner);
                        break;
                }
                break;
            case 5:
                System.out.println("1.\tDisplay list customers use service");
                System.out.println("2.\tDisplay list customers get voucher");
                System.out.println("3.\tReturn main menu");
                System.out.print("Enter number which you wanna choose");
                numbers=scanner.nextInt();
                switch (numbers){
                    case 3:
                        returnMenu(scanner);
                        break;
                }
                break;
            case 6:
                System.exit(6);

        }
    }
}
