package com.sjprogramming.empapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeDaoImplements implements EmployeeDaoInterface {
    Connection con;
    @Override
    public void createEmployee(Employee employee) {
        con = DBConnection.createDBConnetion();
        String query = "insert into employee values (?,?,?,?)";
        try{
            PreparedStatement pstm = con.prepareStatement(query);

            pstm.setInt(1, employee.getId());
            pstm.setString(2, employee.getName());
            pstm.setDouble(3,employee.getSalary());
            pstm.setInt(4,employee.getAge());
            int count = pstm.executeUpdate();
            if(count!=0)
                System.out.println("Employee inserted Successfully !");


        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void showAllEmployee() {

            con = DBConnection.createDBConnetion();
            String query = "select * from employee";
            System.out.println("Employee Details Below:");
            System.out.format("%s\t%s\t%s\t%s\n","Id","Name", "Salary","Age");
        System.out.println("=============================================================================");
            try {
                Statement statement = con.createStatement();
                ResultSet result = statement.executeQuery(query);
                while (result.next()){
                    System.out.format("%d\t%s\t%f\t%d\n",result.getInt(1),result.getString(2),
                            result.getDouble(3),result.getInt(4) );
                    System.out.println("=============================================================================");
                }

            }catch (Exception ex){
                ex.printStackTrace();
            }
    }

    @Override
    public void showEmployeeBasedOnID(int id) {
        con = DBConnection.createDBConnetion();
        String query= "select * from employee where id =" + id;
        try{
            Statement statement= con.createStatement();
            ResultSet result = statement.executeQuery(query);
            while(result.next()){
                 System.out.format("%d\t%s\t%f\t%d\n",result.getInt(1),result.getString(2),
                            result.getDouble(3),result.getInt(4) );
            }
        }catch (Exception ex){
            ex.printStackTrace();

        }

    }

    @Override
    public void updateEmployee(int id, String name) {
        con = DBConnection.createDBConnetion();
        String query = "update employee set name = ? where id = ?";
        try{
            PreparedStatement preparedStatement= con.prepareStatement(query);
            preparedStatement.setString(1,name);
            preparedStatement.setInt(2,id);
            int count = preparedStatement.executeUpdate();
            if(count!=0){
                System.out.println("Employee Details Updated Successfully!");
            }

        }catch (Exception ex){
            ex.printStackTrace();

        }

    }

    @Override
    public void deleteEmployee(int id) {
        con = DBConnection.createDBConnetion();
        String query = "delete from employee where id =?";
        try {
            PreparedStatement preparedStatement =con.prepareStatement(query);
            preparedStatement.setInt(1,id);
            int count = preparedStatement.executeUpdate();
            if (count!=0)
                System.out.println("Employee Deleted Successfully! + id");

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
