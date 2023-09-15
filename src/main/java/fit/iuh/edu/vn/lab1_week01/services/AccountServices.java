package fit.iuh.edu.vn.lab1_week01.services;

import fit.iuh.edu.vn.lab1_week01.entities.Account;
import fit.iuh.edu.vn.lab1_week01.entities.GrantAccess;
import fit.iuh.edu.vn.lab1_week01.entities.Role;
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

    public void createAccount(Account ac) {
        accountRespository.createAccount(ac);
    }

    public void creategrantaccount(GrantAccess grantAccess) {
        accountRespository.creategrantaccount(grantAccess);
    }

    public GrantAccess getAccountUpdate(int id) {
        return accountRespository.getAccountUpdate(id);
    }

    public void updateAccount(Account ac) {
        accountRespository.updateAccount(ac);
    }

    public void updateGrantaccount(GrantAccess access) {
        accountRespository.updateGrantaccount(access);
    }

    public void deleteAccount(Account ac) {
        accountRespository.deleteAccount(ac);
    }

    public void deleteGrantAccount(GrantAccess access) {
        accountRespository.deleteGrantAccount(access);
    }

    public List<GrantAccess> getAllAccountRoleStaff() {
        return accountRespository.getAllAccountRoleStaff();
    }

    public void updateAccountStaff(Account ac) {
        accountRespository.updateAccountStaff(ac);
    }

}
