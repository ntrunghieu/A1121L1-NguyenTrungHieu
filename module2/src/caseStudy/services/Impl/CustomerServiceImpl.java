package caseStudy.services.Impl;

import caseStudy.models.Customer;
import caseStudy.models.Employee;
import caseStudy.services.CustomerService;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    static List<Customer> customerLinkedList=new LinkedList<>();
    static {
        System.out.println("----------- CUSTOMER MANAGEMENT INFORMATION -------------");
    }
    static Scanner scanner=new Scanner(System.in);
    @Override
    public void displayService() {
        for (Customer customer: customerLinkedList) {
            System.out.println(customer.toString());
        }
    }

    @Override
    public void addNew() {
        Customer customer=getCustomer();
        customerLinkedList.add(customer);


    }
    public Customer getCustomer(){
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

        return new Customer(name,idCard,phone,email,gender,idCustomer,typeMember,address);
    }

    @Override
    public void edit() {
        Customer customerFound = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Update by ID Employee");
        System.out.print("Enter the employee ID to edit: ");
        String checkId = scanner.nextLine();

        for (Customer item: customerLinkedList) {
            customerFound=item;
            break;
        }
        if (customerFound!=null){
            for (int i = 0; i < customerLinkedList.size(); i++) {
                if (customerLinkedList.get(i).getIDCustomer().contains(checkId)) {
                    System.out.println("Input update information");
                    Customer customer = getCustomer();
                    customerLinkedList.set(i, customer);
                }
            }
        }else {
            System.out.println("Khong tim thay ma khach hang: "+checkId);
        }
    }

    @Override
    public void remove() {

    }
}
