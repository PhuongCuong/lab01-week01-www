package fit.iuh.edu.vn.lab1_week01.services;

import fit.iuh.edu.vn.lab1_week01.entities.Role;
import fit.iuh.edu.vn.lab1_week01.respositories.RoleRespository;
import jakarta.inject.Inject;

import java.util.List;

public class RoleServices {
    @Inject
    private RoleRespository roleRespository;

    public List<Role> getAllrole() {
        return roleRespository.getAllrole();
    }

    public void createRole(Role role) {
        roleRespository.createRole(role);
    }

    public void deleteRole(Role role) {
        roleRespository.deleteRole(role);
    }

    public void updateRole(Role role) {
        roleRespository.updateRole(role);
    }

    public Role getRole(int id) {
        return roleRespository.getRole(id);
    }

    public void updateDeleteRow(Role role) {
        roleRespository.updateDeleteRow(role);
    }
}
