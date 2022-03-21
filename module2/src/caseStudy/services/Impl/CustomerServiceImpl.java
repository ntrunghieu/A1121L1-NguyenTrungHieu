package caseStudy.services.Impl;

import caseStudy.models.Customer;
import caseStudy.models.Employee;
import caseStudy.services.CustomerService;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    static ArrayList<Customer> customerArrayList=new ArrayList<Customer>();
    static {
        System.out.println("----------- CUSTOMER MANAGEMENT INFORMATION -------------");
    }
    static Scanner scanner=new Scanner(System.in);
    @Override
    public void displayService() {
        for (Customer customer: customerArrayList) {
            System.out.println(customer.toString());
        }
    }

    @Override
    public void addNew() {
        System.out.println("Name: ");
        String name=scanner.nextLine();
        System.out.println("Email: ");
        String email=scanner.nextLine();
        System.out.println("Gender: ");
        String gender=scanner.nextLine();
        System.out.println("ID Customer: ");
        String idCustomer=scanner.nextLine();
        System.out.println("Address: ");
        String address=scanner.nextLine();
        System.out.println("Type customer: ");
        String typeMember=scanner.nextLine();
        System.out.print("ID card: ");
        int idCard=scanner.nextInt();
        System.out.println("Phone number: ");
        int phone=scanner.nextInt();
        Customer customer=new Customer(name,idCard,phone,email,gender,idCustomer,typeMember,address);
        customerArrayList.add(customer);
    }

    @Override
    public void edit() {

    }

    @Override
    public void remove() {

    }
}
