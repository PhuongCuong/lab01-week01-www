package fit.iuh.edu.vn.lab1_week01.respositories;

import fit.iuh.edu.vn.lab1_week01.entities.Role;

import java.util.List;

public class RoleRespository {
    private DataBase dataBase;

    public RoleRespository() {
        dataBase = new DataBase();
    }

    public List<Role> getAllrole() {
        return dataBase.getAllRole();
    }

    public void createRole(Role role) {
        dataBase.createRole(role);
    }

    public void deleteRole(Role role) {
        dataBase.deleteRole(role);
    }

    public void updateRole(Role role) {
        dataBase.updateRole(role);
    }

    public Role getRole(int id) {
        return dataBase.getRole(id);
    }

    public void updateDeleteRow(Role role) {
        dataBase.updateDeleteRow(role);
    }
}
