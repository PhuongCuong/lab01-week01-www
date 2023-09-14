package fit.iuh.edu.vn.lab1_week01.services;

import fit.iuh.edu.vn.lab1_week01.entities.Account;
import fit.iuh.edu.vn.lab1_week01.entities.GrantAccess;
import fit.iuh.edu.vn.lab1_week01.respositories.AccountRespository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.PathParam;

import java.util.List;

@RequestScoped
public class AccountServices {
    @Inject
    private AccountRespository accountRespository;

    public List<Account> getAllaccount() {
        return accountRespository.getAllaccount();
    }

    public Account getAccount(String email, String password) {
        return accountRespository.getAccount(email, password);
    }

    public GrantAccess getAccountRole(String email, String password) {
        return accountRespository.getAccountRole(email, password);
    }

    public List<GrantAccess> getAllAcountRole() {
        return accountRespository.getAllAccountRole();
    }
}
