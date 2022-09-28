/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeesystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author SONY
 */
public class EmployeeSystem {

    public static HashMap<String, Integer> getManagerAllocation(List<Manager> manager) {
        HashMap<String, Integer> map = new HashMap<>();
        for (Manager m : manager) {
            int managerAllocation = 0;
            int supermanagerAllocation = 0;
            if (m.getEmployee() != null) {
                List<EmployeeType> employee = m.getEmployee();
                for (EmployeeType emp : employee) {
                    managerAllocation = managerAllocation + emp.getAllocation();
                }
            }
            if (m.getManagerCollection() != null) {
                HashMap<Manager, List<EmployeeType>> managerCollection = m.getManagerCollection();
                for (Manager mkey : managerCollection.keySet()) {
                    managerAllocation = managerAllocation + mkey.getManagerAllocation();
                    if (managerCollection.get(mkey) != null) {
                        List<EmployeeType> employee = managerCollection.get(mkey);
                        for (EmployeeType emp : employee) {
                            managerAllocation = managerAllocation + emp.getAllocation();
                        }
                    }
                }

            }
            supermanagerAllocation = supermanagerAllocation + m.getManagerAllocation();
            map.put(m.getName(), supermanagerAllocation + managerAllocation);
        }
        return map;
    }

    public static int getDepartmentAllocation(List<Manager> manager) {
        int departmentAllocation = 0;
        HashMap<String, Integer> map = getManagerAllocation(manager);
        for (String s : map.keySet()) {
            departmentAllocation = departmentAllocation + map.get(s);
        }
        System.out.println("Total Department Collection : " + departmentAllocation);
        return departmentAllocation;
    }

    public static List getNotReportedManagers(List<Manager> manager) {
        List<String> managerlist = new ArrayList<>();
        for (Manager m : manager) {
            if (m.getManagers() == null && m.getEmployee() == null && m.getManagerCollection() == null) {
                managerlist.add(m.getName());
            } else if (m.getManagers() == null && m.getEmployee() == null && m.getManagerCollection() != null) {
                HashMap<Manager, List<EmployeeType>> managerCollection = m.getManagerCollection();
                for (Manager m2 : managerCollection.keySet()) {
                    if (managerCollection.get(m2) == null) {
                        managerlist.add(m2.getName());
                    }
                }

            }
        }
        System.out.println("Managers with no one reporting : " + managerlist.toString());
        return managerlist;
    }

    public static void main(String[] args) {
        try {
            List<EmployeeType> employeelist = new ArrayList<>();
            List<Manager> managerlist = new ArrayList<>();
            Manager manager = new Manager();
            manager.setName("ManagerA");
            EmployeeType employee = new EmployeeType();
            employee.setName("Developer");
            employee.setAllocation(2000);
            employeelist.add(employee);
            EmployeeType employee2 = new EmployeeType();
            employee2.setName("QATester");
            employee2.setAllocation(1000);
            employeelist.add(employee2);
            manager.setEmployee(employeelist);
            manager.setManagerAllocation(600);
            managerlist.add(manager);
            Manager manager2 = new Manager();
            manager2.setName("ManagerC");
            List<EmployeeType> employeelist2 = new ArrayList<>();
            EmployeeType employee3 = new EmployeeType();
            employee3.setName("Developer");
            employee3.setAllocation(2000);
            employeelist2.add(employee3);
            EmployeeType employee4 = new EmployeeType();
            employee4.setName("QATester");
            employee4.setAllocation(1000);
            employeelist2.add(employee4);
            HashMap<Manager, List<EmployeeType>> managerCollection = new HashMap<>();
            managerCollection.put(manager2, employeelist2);
            manager2.setManagerAllocation(600);
            Manager superManager = new Manager(managerCollection);
            superManager.setName("ManagerB");
            superManager.setManagerAllocation(600);
            managerlist.add(superManager);
            Manager manager3 = new Manager();
            manager3.setName("Manager D");
            manager3.setManagerAllocation(600);
            HashMap<Manager, List<EmployeeType>> managerCollection2 = new HashMap<>();
            managerCollection2.put(manager3, null);
            Manager superManager2 = new Manager(managerCollection2);
            superManager2.setName("ManagerE");
            superManager2.setManagerAllocation(600);
            managerlist.add(superManager2);
            HashMap<String, Integer> map = getManagerAllocation(managerlist);
            for (String s : map.keySet()) {
                System.out.println("Manager Name : " + s);
                System.out.println("Manager Allocation : " + map.get(s));
            }
            getDepartmentAllocation(managerlist);
            getNotReportedManagers(managerlist);
        } catch (Exception ex) {
            System.out.println("Exception in Employee System :" + ex);
        }

    }

}
