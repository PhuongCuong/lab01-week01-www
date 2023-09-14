package fit.iuh.edu.vn.lab1_week01;

import fit.iuh.edu.vn.lab1_week01.entities.Account;
import fit.iuh.edu.vn.lab1_week01.respositories.AccountRespository;
import fit.iuh.edu.vn.lab1_week01.respositories.DataBase;
import fit.iuh.edu.vn.lab1_week01.services.AccountServices;
import jakarta.inject.Inject;

import java.util.List;

public class TestSQL {
    @Inject
    private static AccountRespository accountRespository;

    public static void main(String[] args) {
        // Gọi hàm getAllaccount để lấy danh sách tài khoản
//        accountRespository = new AccountRespository();
        List<Account> accountList = accountRespository.getAllaccount();

        // Kiểm tra và in ra danh sách tài khoản
        if (accountList != null && !accountList.isEmpty()) {
            for (Account account : accountList) {
                System.out.println("Account ID: " + account.getAccount_Id());
                System.out.println("Username: " + account.getFull_name());
                System.out.println("Password: " + account.getPassword());
                System.out.println("Name: " + account.getPhone());
                System.out.println("Email: " + account.getEmail());
                System.out.println("Age: " + account.getStatus());
                System.out.println("---------------");
            }
        } else {
            System.out.println("Không có tài khoản nào.");
        }
    }
}
