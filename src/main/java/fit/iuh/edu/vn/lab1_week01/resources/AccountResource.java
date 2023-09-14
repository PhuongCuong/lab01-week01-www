package fit.iuh.edu.vn.lab1_week01.resources;

import fit.iuh.edu.vn.lab1_week01.entities.Account;
import fit.iuh.edu.vn.lab1_week01.services.AccountServices;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/account")
public class AccountResource {
    @Inject
    private AccountServices accountServices;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
//    public List<Account> getAllaccount() {
//        return accountServices.getAllaccount();
//    }
    public String gethello() {
        return "Hello word";
    }
}
