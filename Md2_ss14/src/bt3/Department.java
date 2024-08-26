package bt3;

public class Department {
    private final String departmentId;
    private String departmentName;
    private int totalMembers;

    public  Department( String departmentId, String departmentName ) {
        if (departmentId == null || !departmentId.matches("^D\\d{3}$")) {
            throw new IllegalArgumentException("Mã phòng ban phải bắt đầu bằng kí tự D và có đúng 4 kí tự.");
        }
        if (departmentName == null || departmentName.isEmpty()) {
            throw new IllegalArgumentException("Tên phòng ban không được trống.");
        }
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.totalMembers = 0;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        if (departmentName == null || departmentName.isEmpty()) {
            throw new IllegalArgumentException("Tên phòng ban không được trống.");
        }
        this.departmentName = departmentName;
    }

    public int getTotalMembers() {
        return totalMembers;
    }

    public void incrementTotalMembers() {
        this.totalMembers++;
    }

    public void decrementTotalMembers() {
        if (this.totalMembers > 0) {
            this.totalMembers--;
        }
    }

    @Override
    public String toString() {
        return "Department ID: " + departmentId + ", Name: " + departmentName + ", Total Members: " + totalMembers;
    }
}



