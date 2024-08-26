package bt3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    private static List<Department> departments = new ArrayList<>();
    private static List<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("---- QUẢN TRỊ NHÂN SỰ ----");
            System.out.println("1. Quản trị phòng ban");
            System.out.println("2. Quản trị nhân viên");
            System.out.println("3. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    manageDepartments(scanner);
                    break;
                case 2:
                    manageEmployees(scanner);
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void manageDepartments(Scanner scanner) {
        int choice;
        do {
            System.out.println("---- QUẢN TRỊ PHÒNG BAN ----");
            System.out.println("1. Hiển thị danh sách phòng ban");
            System.out.println("2. Thêm mới phòng ban");
            System.out.println("3. Chỉnh sửa tên phòng ban");
            System.out.println("4. Hiển thị danh sách nhân viên của phòng ban");
            System.out.println("5. Xóa phòng ban");
            System.out.println("0. Quay lại");
            System.out.print("Chọn chức năng: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    displayDepartments();
                    break;
                case 2:
                    addDepartment(scanner);
                    break;
                case 3:
                    editDepartment(scanner);
                    break;
                case 4:
                    displayEmployeesByDepartment(scanner);
                    break;
                case 5:
                    deleteDepartment(scanner);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 0);
    }

    private static void displayDepartments() {
        System.out.println("Danh sách phòng ban:");
        for (Department dept : departments) {
            System.out.println(dept);
        }
    }

    private static void addDepartment(Scanner scanner) {
        System.out.print("Nhập mã phòng ban: ");
        String departmentId = scanner.nextLine();
        System.out.print("Nhập tên phòng ban: ");
        String departmentName = scanner.nextLine();
        try {
            Department department = new Department(departmentId, departmentName);
            departments.add(department);
            System.out.println("Phòng ban đã được thêm thành công.");
        } catch (IllegalArgumentException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
    }

    private static void editDepartment(Scanner scanner) {
        System.out.print("Nhập mã phòng ban cần chỉnh sửa: ");
        String departmentId = scanner.nextLine();
        Department department = findDepartmentById(departmentId);
        if (department != null) {
            System.out.print("Nhập tên phòng ban mới: ");
            String departmentName = scanner.nextLine();
            department.setDepartmentName(departmentName);
            System.out.println("Tên phòng ban đã được chỉnh sửa.");
        } else {
            System.out.println("Phòng ban không tồn tại.");
        }
    }

    private static void displayEmployeesByDepartment(Scanner scanner) {
        System.out.print("Nhập mã phòng ban: ");
        String departmentId = scanner.nextLine();
        Department department = findDepartmentById(departmentId);
        if (department != null) {
            System.out.println("Danh sách nhân viên trong phòng " + department.getDepartmentName() + ":");
            for (Employee emp : employees) {
                if (emp.getDepartment().equals(department)) {
                    System.out.println(emp);
                }
            }
        } else {
            System.out.println("Phòng ban không tồn tại.");
        }
    }

    private static void deleteDepartment(Scanner scanner) {
        System.out.print("Nhập mã phòng ban cần xóa: ");
        String departmentId = scanner.nextLine();
        Department department = findDepartmentById(departmentId);
        if (department != null) {
            if (department.getTotalMembers() == 0) {
                departments.remove(department);
                System.out.println("Phòng ban đã được xóa.");
            } else {
                System.out.println("Không thể xóa phòng ban vì còn nhân viên trong phòng.");
            }
        } else {
            System.out.println("Phòng ban không tồn tại.");
        }
    }

    private static Department findDepartmentById(String departmentId) {
        for (Department dept : departments) {
            if (dept.getDepartmentId().equals(departmentId)) {
                return dept;
            }
        }
        return null;
    }

    private static void manageEmployees(Scanner scanner) {
        int choice;
        do {
            System.out.println("---- QUẢN TRỊ NHÂN VIÊN ----");
            System.out.println("1. Hiển thị danh sách nhân viên");
            System.out.println("2. Xem chi tiết thông tin nhân viên");
            System.out.println("3. Thêm mới nhân viên");
            System.out.println("4. Chỉnh sửa thông tin nhân viên");
            System.out.println("5. Xóa nhân viên");
            System.out.println("0. Quay lại");
            System.out.print("Chọn chức năng: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    displayEmployees();
                    break;
                case 2:
                    viewEmployeeDetails(scanner);
                    break;
                case 3:
                    addEmployee(scanner);
                    break;
                case 4:
                    editEmployee(scanner);
                    break;
                case 5:
                    deleteEmployee(scanner);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 0);
    }

    private static void displayEmployees() {
        System.out.println("Danh sách nhân viên:");
        for (Employee emp : employees) {
            System.out.println(emp.getEmployeeId() + " - " + emp.getEmployeeName());
        }
    }

    private static void viewEmployeeDetails(Scanner scanner) {
        System.out.print("Nhập mã nhân viên: ");
        String employeeId = scanner.nextLine();
        Employee employee = findEmployeeById(employeeId);
        if (employee != null) {
            System.out.println(employee);
        } else {
            System.out.println("Nhân viên không tồn tại.");
        }
    }

    private static void addEmployee(Scanner scanner) {
        System.out.print("Nhập mã nhân viên: ");
        String employeeId = scanner.nextLine();
        System.out.print("Nhập tên nhân viên: ");
        String employeeName = scanner.nextLine();
        System.out.print("Nhập ngày sinh (dd/MM/yyyy): ");
        String birthdayStr = scanner.nextLine();
        LocalDate birthday = LocalDate.parse(birthdayStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.print("Nhập giới tính (true = nam, false = nữ): ");
        boolean sex = scanner.nextBoolean();
        System.out.print("Nhập lương cơ bản: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();

        Department department = selectDepartment(scanner);
        if (department != null) {
            Employee employee = new Employee(employeeId, employeeName, birthday, sex, salary, department);
            employees.add(employee);
            System.out.println("Nhân viên đã được thêm thành công.");
        } else {
            System.out.println("Không có phòng ban nào để gán cho nhân viên.");
        }
    }

    private static void editEmployee(Scanner scanner) {
        System.out.print("Nhập mã nhân viên cần chỉnh sửa: ");
        String employeeId = scanner.nextLine();
        Employee employee = findEmployeeById(employeeId);
        if (employee != null) {
            System.out.print("Nhập tên nhân viên mới: ");
            String employeeName = scanner.nextLine();
            System.out.print("Nhập ngày sinh mới (dd/MM/yyyy): ");
            String birthdayStr = scanner.nextLine();
            LocalDate birthday = LocalDate.parse(birthdayStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            System.out.print("Nhập giới tính mới (true = nam, false = nữ): ");
            boolean sex = scanner.nextBoolean();
            System.out.print("Nhập lương cơ bản mới: ");
            double salary = scanner.nextDouble();
            scanner.nextLine();

            employee.setEmployeeName(employeeName);
            employee.setBirthday(birthday);
            employee.setSex(sex);
            employee.setSalary(salary);
            System.out.println("Thông tin nhân viên đã được cập nhật.");
        } else {
            System.out.println("Nhân viên không tồn tại.");
        }
    }

    private static void deleteEmployee(Scanner scanner) {
        System.out.print("Nhập mã nhân viên cần xóa: ");
        String employeeId = scanner.nextLine();
        Employee employee = findEmployeeById(employeeId);
        if (employee != null) {
            employees.remove(employee);
            employee.getDepartment().decrementTotalMembers(); // Giảm số lượng nhân viên trong phòng ban
            System.out.println("Nhân viên đã được xóa.");
        } else {
            System.out.println("Nhân viên không tồn tại.");
        }
    }

    private static Employee findEmployeeById(String employeeId) {
        for (Employee emp : employees) {
            if (emp.getEmployeeId().equals(employeeId)) {
                return emp;
            }
        }
        return null;
    }

    private static Department selectDepartment(Scanner scanner) {
        if (departments.isEmpty()) {
            System.out.println("Danh sách phòng ban trống. Vui lòng thêm phòng ban trước.");
            return null;
        }
        System.out.println("Danh sách phòng ban:");
        for (int i = 0; i < departments.size(); i++) {
            System.out.println((i + 1) + ". " + departments.get(i).getDepartmentName());
        }
        System.out.print("Chọn phòng ban: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice > 0 && choice <= departments.size()) {
            return departments.get(choice - 1);
        } else {
            System.out.println("Lựa chọn không hợp lệ.");
            return null;
        }
    }
}
