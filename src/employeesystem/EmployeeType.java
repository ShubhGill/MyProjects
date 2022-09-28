/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeesystem;

/**
 *
 * @author SONY
 */
public class EmployeeType {

    private String name;
    private int allocation;

    public String getName() {
        return name;
    }

    public void setName(String name) throws ManagerException {
        if (name.equalsIgnoreCase("Manager")) {
            throw new ManagerException("Employee Type cannot be set to Manager");
        } else if (!name.equalsIgnoreCase("Developer") && !name.equalsIgnoreCase("QATester")) {
            throw new ManagerException("Employee Type cannot be set to " + name);
        } else {
            this.name = name;
        }

    }

    public int getAllocation() {
        return allocation;
    }

    public void setAllocation(int allocation) {
        this.allocation = allocation;
    }
}
