package caseStudy.services.Impl;

import caseStudy.models.Employee;
import caseStudy.services.EmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {
    static List<Employee> employeeArrayList = new ArrayList<Employee>();

    static {
        System.out.println("----------- EMPLOYEE MANAGEMENT INFORMATION -------------");
    }

    static Scanner scanner = new Scanner(System.in);

    @Override
    public void displayService() {
        for (Employee employee : employeeArrayList) {
            System.out.println(employee.toString());
        }
    }

    @Override
    public void addNew() {
        Employee employee = getEmployee();
        employeeArrayList.add(employee);
    }


    public Employee getEmployee() {
        System.out.println("------ ADD NEW EMPLOYEE ---------");

        System.out.println("Name: ");
        String name = scanner.nextLine();
        System.out.println("Email: ");
        String email = scanner.nextLine();
        System.out.println("Gender: ");
        String gender = scanner.nextLine();
        System.out.println("ID Employee: ");
        String idEmployee = scanner.nextLine();
        System.out.println("Level: ");
        String level = scanner.nextLine();
        System.out.println("Position: ");
        String position = scanner.nextLine();
        System.out.print("ID card: ");
        int idCard = Integer.parseInt(scanner.nextLine());
        System.out.println("Phone number: ");
        String phone = scanner.nextLine();
        System.out.println("Salary: ");
        int salary = Integer.parseInt(scanner.nextLine());
//        Employee employee=new Employee(name,idCard,phone,email,gender,idEmployee,level,position,salary);
//        employeeArrayList.add(employee);

        return new Employee(name, idCard, phone, email, gender, idEmployee, level, position, salary);
    }

    @Override
    public void edit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Update by ID Employee");
        System.out.print("Enter the employee ID to edit: ");
        String checkId = scanner.nextLine();


            for (int i = 0; i < employeeArrayList.size(); i++) {
                if (employeeArrayList.get(i).getIDEmployee().contains(checkId)) {
                    System.out.println("Input update information");
                    Employee employee = getEmployee();
                    employeeArrayList.set(i, employee);
                } else {
                    System.out.println("Khong tim thay ma nhan vien: " + checkId);
                }
            }


//            System.out.println(" 1.Name \n 2.Email \n 3.Gender \n 4.ID Employee \n 5.Level \n 6.Position \n 7.ID Card" +
//                    "\n 8.Phone \n 9.Salary");
//            System.out.print("Enter the information you wanna edit: ");
//            int enter=Integer.parseInt(scanner.nextLine());
//            switch (enter){
//                case 1:
//                    System.out.print("Name: ");
//                    String name=scanner.nextLine();
//                    editEmployee.setName(name);
//                    break;
//                case 2:
//                    System.out.print("Email: ");
//                    String email=scanner.nextLine();
//                    editEmployee.setEmail(email);
//                    break;
//                case 3:
//                    System.out.print("Gender: ");
//                    String gender=scanner.nextLine();
//                    editEmployee.setGender(gender);
//                    break;
//                case 4:
//                    System.out.print("ID Employee: ");
//                    String idEmployee=scanner.nextLine();
//                    editEmployee.setIDEmployee(idEmployee);
//                    break;
//                case 5:
//                    System.out.print("Level: ");
//                    String level=scanner.nextLine();
//                    editEmployee.setLevel(level);
//                    break;
//                case 6:
//                    System.out.print("Position: ");
//                    String position=scanner.nextLine();
//                    editEmployee.setPosition(position);
//                    break;
//                case 7:
//                    System.out.print("ID Card: ");
//                    int idCard=Integer.parseInt(scanner.nextLine());
//                    editEmployee.setIDCard(idCard);
//                    break;
//                case 8:
//                    System.out.print("Phone: ");
//                    int phoneNum=Integer.parseInt(scanner.nextLine());
//                    editEmployee.setPhone(phoneNum);
//                    break;
//                case 9:
//                    System.out.print("Salary: ");
//                    int salary=Integer.parseInt(scanner.nextLine());
//                    editEmployee.setSalary(salary);
//                    break;
//            }
    }


    @Override
    public void remove() {

    }
}
