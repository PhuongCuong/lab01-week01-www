package fit.iuh.edu.vn.lab1_week01.respositories;

import fit.iuh.edu.vn.lab1_week01.entities.Account;
import fit.iuh.edu.vn.lab1_week01.entities.GrantAccess;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.PathParam;

import java.util.List;

@RequestScoped
public class AccountRespository {
    private DataBase dataBase;

    public AccountRespository() {

        dataBase = new DataBase();
    }

    public List<Account> getAllaccount() {
        return dataBase.getAllaccount();
    }

    public Account getAccount(String email, String password) {
        return dataBase.getAccount(email, password);
    }

    public GrantAccess getAccountRole(String email, String password) {
        return dataBase.getAccountRole(email, password);
    }

    public List<GrantAccess> getAllAccountRole() {
        return dataBase.getdsAccountRole();
    }
}
