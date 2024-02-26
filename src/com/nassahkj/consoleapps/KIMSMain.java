package com.nassahkj.consoleapps;

import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;

/**
 * KIMS: Kammwannyi-Investments Management System
 * This will contain several modules implemented in a gradual development process
 * The first module, "the employee-management module"
 * The module encampuses different operations sucha "Register employee, Delete Employee,
 * View all employee, Search a given employee and possibly quiting the system when need be"
 * The system will further be added more modules including but not limitted to " Sales management,
 * Adding different departments, etc"
 * For now, lets first implement the employemnts' module
 * Assumption: the details captured on the employee include the following
 * 1. Name(s), address, contact, date of hire, start_date, salary, employmentStatus(permanent/temporary), 

*/
public class KIMSMain {

    public static void main(String[] kims){
        KIMSImplementClass kimsObj = new KIMSImplementClass();
        int userChoice;
        int empId = 0;
        Scanner scanInput = new Scanner(System.in);
        Employee emp = new Employee();

        //Now try to implement the different operations
        do{
            System.out.println(".............................Kammwanyi-Investment Management System...................\n");
            System.out.println("Employee Managent module..........\n Make your own choice on the following.......\n");
            System.out.println("1. Add New Employee...!\n2. Delete Employee...!\n"+
            "3. View All Employee...!\n4. Search Employee...!\n5. Update Employee...\n"+
            "6. Exit System...!");
            System.out.print("\nYOUR CHOICE: ");
            userChoice = scanInput.nextInt();

            switch (userChoice) {
                case 1:

                    System.out.println("..........Adding employee...!\n");
                    System.out.print("First Name: ");
                    String fName = scanInput.next();
                    System.out.print("Last Name: ");
                    String lName = scanInput.next();
                    System.out.print("Location: ");
                    String location = scanInput.next();
                    System.out.print("Phone Number: ");
                    String pNumber =scanInput.next();
                    System.out.print("Nationality: ");
                    String nationality = scanInput.next();
                    System.out.print("Employement Type: ");
                    String emStatus = scanInput.next();
                    System.out.print("Monthly Salary: ");
                    double emSalary = scanInput.nextDouble();
                    System.out.print("Region of Origin: ");
                    String region = scanInput.next();
                    //Now assgning the values to their respective variables

                    emp.setEmFname(fName);
                    emp.setEmLname(lName);
                    emp.setContact(pNumber);
                    emp.setLocation(location);
                    emp.setNationality(nationality);
                    emp.setRegionOfOrigin(region);
                    emp.setEmSalary(emSalary);
                    emp.setEmType(emStatus);

                    kimsObj.registerEmployee(emp);

                    break;
                
                case 2:
                    //The system user has to privide the user id since it's the only one field that can be unique for all employees
                    System.out.println("...................................Delete user operation.................\n");
                    System.out.print("User Id: ");
                    empId = scanInput.nextInt();
                    //We can provide a warning whether user is sure he wants to do-away with the employee whose id is provided
                    kimsObj.deleteEmp(empId);
                    
                    break;
                
                case 3: 
                    kimsObj.viewAll();
                    break;

                case 4:
                    System.out.println("...................Searching employee..........\n");
                    System.out.print("User Id: ");
                    empId = scanInput.nextInt();
                    kimsObj.searchEmp(empId);
                    break;

                case 5:
                    System.out.println("..............Update employee details.........\n");
                    System.out.print("Enter user id: ");
                    empId = scanInput.nextInt();
                    System.out.print("New First Name: ");

                    String fname = scanInput.next();
                    System.out.print("New Region of Origin: ");
                    String regionOrgin = scanInput.next();

                    kimsObj.updateEmp(empId,fname,regionOrgin);
                    break;

                case 6:
                    System.out.print("Are you sure you want to exit the system...?: ");
                    String userOption = (scanInput.next()).toLowerCase();
                    switch (userOption) {

                        case "yes":
                            kimsObj.exitSystem();
                            break;
                            
                        case "no":

                             break;    
                    
                        default:
                            System.out.println("Wrong entry made...");
                            break;
                    }
                    //kimsObj.Exit();

                         
                default:
                    break;
            }


        }while(true);
        

    }



    
}
