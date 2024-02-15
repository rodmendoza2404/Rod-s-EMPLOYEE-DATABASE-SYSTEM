package com.sjprogramming.empapp;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeDaoInterface dao = new EmployeeDaoImplements();
        System.out.println("Welcome to Employee Management Application!");
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("1.Add Employee\n"+"2.Show All Employee\n"+
                    "3.Show Employee based on ID\n"+"4.Update the Employee\n"+
                    "5.Delete the employee\n");

            System.out.println("Enter: ");

            int ch = sc.nextInt();
            switch(ch){
                case 1:
                    Employee emp = new Employee();
                    System.out.println("Enter ID :");
                    int id = sc.nextInt();
                    System.out.println("Enter name: ");
                    String name= sc.next();
                    System.out.println("Enter Salary: ");
                    double salary = sc.nextDouble();
                    //double check
                    System.out.println("Enter age");
                    int age= sc.nextInt();
                    emp.setId(id);
                    emp.setName(name);
                    emp.setSalary(salary);
                    emp.setAge(age);

                    dao.createEmployee(emp);
                    break;
                case 2:
                    dao.showAllEmployee();
                    break;
                case 3:
                    System.out.println("Enter ID to show details:");
                    int empID = sc.nextInt();
                    dao.showEmployeeBasedOnID(empID);
                case 4 :
                    System.out.println("Enter id to update the info");
                    int employeeID = sc.nextInt();
                    System.out.println("Enter the new name please:");
                      name = sc.next();
                    dao.updateEmployee(employeeID, name);
                    break;

                case 5:
                    System.out.println("Enter the ID to Delete:");
                    id=sc.nextInt();
                    dao.deleteEmployee(id);


                case 6:
                    System.out.println("Thank you for using this Application !");
                    System.exit(0);
                default:
                    System.out.println("Enter valid choice");
                    break;

            }

        }while(true);
    }
}
