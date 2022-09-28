/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeesystem;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author SONY
 */
public class Manager {

    Manager(HashMap<Manager, List<EmployeeType>> managerCollection) {
        this.managerCollection = managerCollection;
    }
    Manager() {

    }
    private String name;
    private List<EmployeeType> employee;
    private List<Manager> managers;
    private int managerAllocation;
    private HashMap<Manager, List<EmployeeType>> managerCollection;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<Manager, List<EmployeeType>> getManagerCollection() {
        return managerCollection;
    }

    public void setManagerCollection(HashMap<Manager, List<EmployeeType>> managerCollection) {
        this.managerCollection = managerCollection;
    }

    public int getManagerAllocation() {
        return managerAllocation;
    }

    public void setManagerAllocation(int managerAllocation) {
        this.managerAllocation = managerAllocation;
    }

    public List<EmployeeType> getEmployee() {
        return employee;
    }

    public void setEmployee(List<EmployeeType> employee) {
        this.employee = employee;
    }

    public List<Manager> getManagers() {
        return managers;
    }

    public void setManagers(List<Manager> managers) {
        this.managers = managers;
    }  

}
