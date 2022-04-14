package caseStudy.services.Impl;

import caseStudy.models.Customer;
import caseStudy.services.CustomerService;
import caseStudy.utils.WriteReadFileBinary;
import caseStudy.utils.WriteReadFileText;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    final String COMMA = ",";
    static List<Customer> customerLinkedList = new LinkedList<>();
    static WriteReadFileBinary writeReadFileBinary =new WriteReadFileBinary();
    private final String path="D:\\CODE\\A1121L1-NguyenTrungHieu\\module2\\src\\caseStudy\\data\\cus.csv";

    static {
        System.out.println("----------- CUSTOMER MANAGEMENT INFORMATION -------------");
    }

    static Scanner scanner = new Scanner(System.in);
    private WriteReadFileText<Customer> customerWriteReadFileText=new WriteReadFileText<>();


    public CustomerServiceImpl() {
        customerLinkedList=getAll();
    }

    public List<Customer> getAll(){
        customerLinkedList.clear();
        List<String> lines=customerWriteReadFileText.readText(path);
        for (String line: lines) {
            String[] arr=line.split(", ");
            Customer customer1=new Customer(arr[0],Integer.parseInt(arr[1]),arr[2],arr[3],arr[4],arr[5],arr[6],arr[7]);
            customerLinkedList.add(customer1);
        }

        return customerLinkedList;
    }
    public void show(List<Customer> customerList) {
        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.printf("%-10s %-20s %-20s %-20s %-20s %-20s%n", "ID Customer", "NAME", "GENDER", "EMAIL", "PHONE", "ID CARD");
        System.out.println("--------------------------------------------------------------------------------------------------------");
        for (Customer customer : customerList) {
            System.out.printf("%-10s %-20s %-20s %-20s %-20s %-20s%n", customer.getIDCustomer(), customer.getName(), customer.getGender(), customer.getEmail(), customer.getPhoneNumber(), customer.getIDCard());
        }
        System.out.println("--------------------------------------------------------------------------------------------------------");

    }
    public void showListCustomer(){
        show(customerLinkedList);
    }


    @Override
    public void displayService() {
//        customerLinkedList= (List<Customer>) writeReadFileBinary.readToFile(path);
//        for (Customer customer : customerLinkedList) {
//            System.out.println(customer.toString());
//        }

    }

    @Override
    public void addNew() {
        Customer customer = getCustomer();
        customerLinkedList.add(customer);
//        writeReadFileBinary.writeToFile(customerLinkedList,path);
        customerWriteReadFileText.writeText(customerLinkedList,path);
//        try (BufferedWriter bf = new BufferedWriter(new FileWriter("D:\\CODE\\A1121L1-NguyenTrungHieu\\module2\\src\\customer.txt", true))) {
//            for (Customer i : customerLinkedList) {
//                bf.newLine();
//                bf.write("Name: " + i.name + COMMA + " Email: " + i.email + COMMA + " Gender: " + i.gender + COMMA +
//                        " ID Customer: " + i.IDCustomer + COMMA + " Phone: " + i.phoneNumber);
//                bf.flush();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }

    public Customer getCustomer() {
        System.out.println("Name: ");
        String name = scanner.nextLine();
        System.out.println("Email: ");
        String email = scanner.nextLine();
        System.out.println("Gender: ");
        String gender = scanner.nextLine();
        System.out.println("ID Customer: ");
        String idCustomer = scanner.nextLine();
        System.out.println("Address: ");
        String address = scanner.nextLine();
        System.out.println("Type customer: ");
        String typeMember = scanner.nextLine();
        System.out.print("ID card: ");
        int idCard = Integer.parseInt(scanner.nextLine());
        System.out.println("Phone number: ");
        String phone = scanner.nextLine();

        return new Customer(name, idCard, phone, email, gender, idCustomer, typeMember, address);
    }

    @Override
    public void edit() {
//        Customer customerFound = null;
        System.out.println("Update by ID Employee");
        System.out.print("Enter the employee ID to edit: ");
        String checkId = scanner.nextLine();

        for (int i = 0; i < customerLinkedList.size(); i++) {
            if (customerLinkedList.get(i).getIDCustomer().contains(checkId)) {
                System.out.println("Input update information");
                Customer customer = getCustomer();
                customerLinkedList.set(i, customer);
            } else {
                System.out.println("Khong tim thay ma nhan vien: " + checkId);
            }
        }
    }

    @Override
    public void remove() {
        System.out.print("Enter the employee ID to edit: ");
        String checkId = scanner.nextLine();
        for (int i = 0; i < customerLinkedList.size(); i++) {
            if (customerLinkedList.get(i).getIDCustomer().contains(checkId)) {
               customerLinkedList.remove(i);
            }
        }
        writeReadFileBinary.writeToFile(customerLinkedList,path);
        System.out.println("successful delete");
    }

}
