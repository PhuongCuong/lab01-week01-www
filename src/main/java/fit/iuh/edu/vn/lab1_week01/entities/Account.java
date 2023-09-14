package fit.iuh.edu.vn.lab1_week01.entities;

public class Account {
    private int account_Id;
    private String full_name;
    private String password;
    private String email;
    private String phone;
    private int status;

    public Account(int account_Id, String full_name, String password, String email, String phone, int status) {
        this.account_Id = account_Id;
        this.full_name = full_name;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.status = status;
    }

    public Account() {
    }

    public int getAccount_Id() {
        return account_Id;
    }

    public String getFull_name() {
        return full_name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public int getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Account{" +
                "account_Id=" + account_Id +
                ", full_name='" + full_name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                '}';
    }
}
