package com.nassahkj.consoleapps;

//This is to generally and purposely keep all our operations abstruct prevent the direct access from actressor and accessors

public interface KIMSInterface {

    void registerEmployee(Employee emp);
    void  viewAll();
    void searchEmp(int empId);
    void deleteEmp(int empId);
    void updateEmp(int empId,String emFname,String emRegionOfOrigion);
    void exitSystem();


    
}
