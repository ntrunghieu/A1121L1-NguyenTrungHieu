package caseStudy.services.Impl;

import caseStudy.models.Employee;
import caseStudy.services.EmployeeService;
import caseStudy.services.Service;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {
    static ArrayList<Employee> employeeArrayList=new ArrayList<Employee>();
    static {
        System.out.println("----------- EMPLOYEE MANAGEMENT INFORMATION -------------");
    }
    static Scanner scanner=new Scanner(System.in);

    @Override
    public void displayService() {
        for (Employee employee: employeeArrayList) {
            System.out.println(employee.toString());
        }
    }

    @Override
    public void addNew() {
        System.out.println("------ ADD NEW EMPLOYEE ---------");

        System.out.println("Name: ");
        String name=scanner.nextLine();
        System.out.println("Email: ");
        String email=scanner.nextLine();
        System.out.println("Gender: ");
        String gender=scanner.nextLine();
        System.out.println("ID Employee: ");
        String idEmployee=scanner.nextLine();
        System.out.println("Level: ");
        String level=scanner.nextLine();
        System.out.println("Position: ");
        String position=scanner.nextLine();
        System.out.print("ID card: ");
        int idCard=scanner.nextInt();
        System.out.println("Phone number: ");
        int phone=scanner.nextInt();
        System.out.println("Salary: ");
        int salary=scanner.nextInt();
        Employee employee=new Employee(name,idCard,phone,email,gender,idEmployee,level,position,salary);
        employeeArrayList.add(employee);

    }

    @Override
    public void edit() {

    }

    @Override
    public void remove() {

    }
}
