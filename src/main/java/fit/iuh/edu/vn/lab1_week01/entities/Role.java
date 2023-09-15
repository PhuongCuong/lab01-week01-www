package fit.iuh.edu.vn.lab1_week01.entities;

public class Role {
    private int role_Id;
    private String role_name;
    private String description;
    private int status;

    public Role(int role_Id, String role_name, String description, int status) {
        this.role_Id = role_Id;
        this.role_name = role_name;
        this.description = description;
        this.status = status;
    }

    public Role(int role_Id, String role_name) {
        this.role_Id = role_Id;
        this.role_name = role_name;
    }

    public Role() {
    }

    public int getRole_Id() {
        return role_Id;
    }

    public void setRole_Id(int role_Id) {
        this.role_Id = role_Id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Role{" +
                "role_Id=" + role_Id +
                ", role_name='" + role_name + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}
