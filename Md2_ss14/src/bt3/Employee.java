package bt3;

import java.time.LocalDate;

public class Employee {
    private String employeeId;
    private String employeeName;
    private LocalDate birthday;
    private boolean sex;
    private double salary;
    private Employee manager;
    private Department department;

    public Employee(String employeeId, String employeeName, LocalDate birthday, boolean sex, double salary, Department department) {
        if (employeeId == null || !employeeId.matches("^E\\d{4}$")) {
            throw new IllegalArgumentException("Mã nhân viên phải bắt đầu bằng kí tự E và có 5 kí tự.");
        }
        if (employeeName == null || employeeName.isEmpty()) {
            throw new IllegalArgumentException("Tên nhân viên không được trống.");
        }
        if (department == null) {
            throw new IllegalArgumentException("Phòng ban không được null.");
        }
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.birthday = birthday;
        this.sex = sex;
        this.salary = salary;
        this.department = department;
        department.incrementTotalMembers();
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        if (employeeName == null || employeeName.isEmpty()) {
            throw new IllegalArgumentException("Tên nhân viên không được trống.");
        }
        this.employeeName = employeeName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        if (this.department != null) {
            this.department.decrementTotalMembers();
        }
        this.department = department;
        department.incrementTotalMembers();
    }

    @Override
    public String toString() {
        return "Employee ID: " + employeeId + ", Name: " + employeeName + ", Birthday: " + birthday +
                ", Sex: " + (sex ? "Male" : "Female") + ", Salary: " + salary +
                ", Department: " + department.getDepartmentName() +
                ", Manager: " + (manager != null ? manager.getEmployeeName() : "None");
    }
}
