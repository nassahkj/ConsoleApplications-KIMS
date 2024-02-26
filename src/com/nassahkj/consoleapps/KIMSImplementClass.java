package com.nassahkj.consoleapps;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

//Provide all the implementation logic logic of the abstruct methods declared in the interface
public class KIMSImplementClass implements KIMSInterface {
    Connection conn;

    @Override
    public void registerEmployee( Employee emp) {
        //first access the connection
        conn = DataConnections.getDbConnection(); //gets the database connection handle

        //create an sql query string to insert the data into the database table
        String insertQuery = "insert into Kammwanyi_investments.employees(employees.empFname,employees.empLname,employees.empLocation,employees.empPhoneNumber,employees.empNationality,employees.empStatus,employees.empSalary,employees.empHireDate,employees.empRegionOrigin) values (?,?,?,?,?,?,?,now(),?) ";

       try{
        PreparedStatement pm = conn.prepareStatement(insertQuery);
        pm.setString(1, emp.getEmFname());
        pm.setString(2, emp.getEmLname());
        pm.setString(3, emp.getLocation());
        pm.setString(4, emp.getContact());
        pm.setString(5, emp.getNationality());
        pm.setString(6, emp.getEmType());
        pm.setDouble(7, emp.getEmSalary());
        pm.setString(8, emp.getRegionOfOrigin());
        int returnValue = pm.executeUpdate(); // no success, the function returns a non-zero integer value
        if(returnValue != 0){
            System.out.println("Employee added successfully.....");
        }

       }catch(Exception ex){
        ex.printStackTrace();
       }
    }

    @Override
    public void viewAll() {
        //get the database connection handle
        conn = DataConnections.getDbConnection();
        String queryString = "select *from kammwanyi_investments.employees";
        try{
            
            Statement stm = conn.createStatement();//
            ResultSet rst = stm.executeQuery(queryString); //Returns a resultset
            System.out.println(".................................Kammwanyi Investments Employees.............\n\n");
            System.out.format("%s %s %s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\n",
            "EmpId","FirstName","LastName","Location","Contact","Nationality","EmpStatus","Salary",
            "Hire Date","Region");
            while (rst.next()) {
                System.out.format("%d\t%s\t%s\t%s\t%s\t%s\t%s\t%.0f\t%s\t%s",rst.getInt(1),rst.getString(2),rst.getString(3),
                rst.getString(4),rst.getString(5),rst.getString(6),rst.getString(7),rst.getDouble(8),rst.getDate(9),rst.getString(10));
                System.out.println("\n================================================================================================================");

                
            }



        }catch(Exception ex){
            ex.printStackTrace();

        }
    
    }

    @Override
    public void searchEmp(int empId) {
        conn = DataConnections.getDbConnection();
        String returnString = "select *from kammwanyi_investments.employees where employees.emp_id = "+empId;
        System.out.format("%s %s %s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\n",
            "EmpId","FirstName","LastName","Location","Contact","Nationality","EmpStatus","Salary",
            "Hire Date","Region");
        try{
            Statement stm = conn.createStatement();
            ResultSet rst = stm.executeQuery(returnString);
            while (rst.next()) {
                System.out.format("\n%d\t%s\t%s\t%s\t%s\t%s\t%s\t%.0f\t%s\t%s",rst.getInt(1),rst.getString(2),rst.getString(3),
                rst.getString(4),rst.getString(5),rst.getString(6),rst.getString(7),rst.getDouble(8),rst.getDate(9),rst.getString(10));
                System.out.println("\n================================================================================================================");

    }
   }catch(Exception ex){
    ex.printStackTrace();   
   }
   }

    @Override
    public void deleteEmp(int empId) {
        //get database connection
        conn = DataConnections.getDbConnection();
        //String userDetails = "select employees.emp_idemployees.empFname,employees.empLname from kammwanyi_investments"
        String delString = "delete from kammwanyi_investments.employees where employees.emp_id = ?";
        String selectString = "select employees.emp_id,employees.empFname,employees.empLname from kammwanyi_investments.employees where employees.emp_id = "+empId;
        try{
            PreparedStatement pstm = conn.prepareStatement(delString);
            Statement stm = conn.createStatement();
            ResultSet rst = stm.executeQuery(selectString);
            System.out.format("%s\t%s\t%s\n","Emp_id","Fname","Lname");
            System.out.println("=================================================================================");
            while(rst.next()){
                System.out.format("%d\t%s\t%s",rst.getInt(1),rst.getString(2),rst.getString(3));
            }
            System.out.print("\n\nAre you sure you delete the above user (yes/no): ");
            Scanner scan = new Scanner(System.in);
            String userInput = (scan.nextLine()).toLowerCase();
            switch (userInput) {
                case "yes":
                    pstm.setInt(1, empId);
                    int returnValue = pstm.executeUpdate();
                    if(returnValue != 0){
                            System.out.println("Employee deleted successfully....");
                              }
                    break;
                case "no":
                    break;

        
            
                default:
                     System.out.println("Wrong entry...");
                    break;
            }
   

        }catch(Exception ex){
            ex.printStackTrace();
        }

    
    }

    @Override
    public void updateEmp(int empId,String fName,String regionOfOrgin) {
        conn = DataConnections.getDbConnection();
        //depends on the user id provided by the system user
        //Assumption, the user names are th fieldsto be updated
         
        String updateString = "update kammwanyi_investments.employees set employees.empFname = ?, employees.empRegionOrigin = ? where employees.emp_id = "+empId;
        try{
            PreparedStatement pst = conn.prepareStatement(updateString);
            pst.setString(1, fName);
            pst.setString(2, regionOfOrgin);
            int resultCount = pst.executeUpdate();
            if(resultCount != 0){
                System.out.println("Employee updated successfully");
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    
    
    }
    public void exitSystem(){
        
        System.exit(0);
    }

    
}
