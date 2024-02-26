package com.nassahkj.consoleapps;

public class Employee {
    private int emId;
    private String emFname;
    private String emLname;
    private double emSalary;//But this is a field o be managed based on the department and employment status
    private String location;
    private String contact;
    private String nationality;
    private String regionOfOrigin;
    private String hire_date;
    private String emType; //Should be either permanent/temporary

    public int getEmId() {
        return emId;
    }
    public void setEmId(int emId) {
        this.emId = emId;
    }
    public String getEmFname() {
        return emFname;
    }
    public void setEmFname(String emFname) {
        this.emFname = emFname;
    }
    public String getEmLname() {
        return emLname;
    }
    public void setEmLname(String emLname) {
        this.emLname = emLname;
    }
    public double getEmSalary() {
        return emSalary;
    }
    public void setEmSalary(double emSalary) {
        this.emSalary = emSalary;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }
    public String getNationality() {
        return nationality;
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    public String getRegionOfOrigin() {
        return regionOfOrigin;
    }
    public void setRegionOfOrigin(String regionOfOrigin) {
        this.regionOfOrigin = regionOfOrigin;
    }
    public String getHire_date() {
        return hire_date;
    }
    public void setHire_date(String hire_date) {
        this.hire_date = hire_date;
    }
    public String getEmType() {
        return emType;
    }
    public void setEmType(String emType) {
        this.emType = emType;
    }
    public Employee(int emId, String emFname, String emLname, double emSalary, String location, String contact,
            String nationality, String regionOfOrigin, String hire_date, String emType) {
        this.emId = emId;
        this.emFname = emFname;
        this.emLname = emLname;
        this.emSalary = emSalary;
        this.location = location;
        this.contact = contact;
        this.nationality = nationality;
        this.regionOfOrigin = regionOfOrigin;
        this.hire_date = hire_date;
        this.emType = emType;
    }
    
    public Employee() {
        //Default constructor is to  be used during when the class is invoked and the parameterized is no necessar
        
    }
    @Override
    public String toString() {
        return "Employee [emId=" + emId + ", emFname=" + emFname + ", emLname=" + emLname + ", emSalary=" + emSalary
                + ", location=" + location + ", contact=" + contact + ", nationality=" + nationality
                + ", regionOfOrigin=" + regionOfOrigin + ", hire_date=" + hire_date + ", emType=" + emType + "]";
    }
    
    
    
}
