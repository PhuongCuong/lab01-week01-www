package fit.iuh.edu.vn.lab1_week01.respositories;

import fit.iuh.edu.vn.lab1_week01.entities.Account;
import fit.iuh.edu.vn.lab1_week01.entities.GrantAccess;
import fit.iuh.edu.vn.lab1_week01.entities.Log;
import fit.iuh.edu.vn.lab1_week01.entities.Role;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private Connection connection = null;

    public DataBase() {
        String url = "jdbc:mysql://localhost:3306/mydb";
        try {
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection(url, "root", null);
            System.out.println(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }


    public List<Account> getAllaccount() {
        PreparedStatement statement = null;
        List<Account> dsAccount = new ArrayList<>();
        try {
            statement = connection.prepareStatement("SELECT * FROM account");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Account ac = new Account(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getInt(6));
                dsAccount.add(ac);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dsAccount;
    }

    public Account getAccount(String email, String password) {
        PreparedStatement statement = null;
        Account ac = null;
        try {
            statement = connection.prepareStatement("SELECT account.* , grant_access.note FROM account INNER JOIN grant_access ON account.id = grant_access.account_id" +
                    " where email = ? and password = ?");
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                ac = new Account(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getInt(6));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ac;
    }

    public GrantAccess getAccountRole(String email, String password) {
        PreparedStatement statement = null;
        GrantAccess grantAccess = null;
        try {
            statement = connection.prepareStatement("SELECT account.*,role.role_name,role.id, grant_access.is_grant FROM grant_access INNER JOIN account ON grant_access.account_id = account.id \n" +
                    "INNER JOIN role ON grant_access.role_id = role.id where email = ? and password = ?");
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                grantAccess = new GrantAccess(new Account(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getInt(6)),
                        new Role(rs.getInt(8), rs.getString(7)), rs.getInt(9)
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return grantAccess;
    }

    public List<GrantAccess> getdsAccountRole() {
        PreparedStatement statement = null;
        List<GrantAccess> dsAccount = new ArrayList<>();
        try {
            statement = connection.prepareStatement("SELECT account.*,role.role_name,role.id, grant_access.is_grant FROM grant_access INNER JOIN account ON grant_access.account_id = account.id \n" +
                    "INNER JOIN role ON grant_access.role_id = role.id");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                GrantAccess grantAccess = new GrantAccess(new Account(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getInt(6)),
                        new Role(rs.getInt(8), rs.getString(7)), rs.getInt(9)
                );
                dsAccount.add(grantAccess);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dsAccount;
    }

    public List<GrantAccess> getdsAccountRoleStaff() {
        PreparedStatement statement = null;
        List<GrantAccess> dsAccount = new ArrayList<>();
        try {
            statement = connection.prepareStatement("SELECT account.*,role.role_name,role.id, grant_access.is_grant FROM grant_access INNER JOIN account ON grant_access.account_id = account.id \n" +
                    "INNER JOIN role ON grant_access.role_id = role.id where role.id = 3");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                GrantAccess grantAccess = new GrantAccess(new Account(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getInt(6)),
                        new Role(rs.getInt(8), rs.getString(7)), rs.getInt(9)
                );
                dsAccount.add(grantAccess);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dsAccount;
    }

    public void CreateAccount(Account ac) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO account VALUES (?,?,?,?,?,?)");
            statement.setInt(1, ac.getAccount_Id());
            statement.setString(2, ac.getFull_name());
            statement.setString(3, ac.getPassword());
            statement.setString(4, ac.getEmail());
            statement.setString(5, ac.getPhone());
            statement.setInt(6, ac.getStatus());
            int rowsInserted = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void CreateGrantAccess(GrantAccess grantAccess) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO grant_access VALUES (?,?,?,?)");
            statement.setInt(1, grantAccess.getAccount().getAccount_Id());
            statement.setInt(2, grantAccess.getRole().getRole_Id());
            statement.setInt(3, grantAccess.getIs_grant());
            statement.setString(4, grantAccess.getNode());
            int rowsInserted = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public GrantAccess getAccountUpdate(int id) {
        PreparedStatement statement = null;
        GrantAccess grantAccess = null;
        try {
            statement = connection.prepareStatement("SELECT account.*,role.role_name,role.id, grant_access.is_grant FROM grant_access INNER JOIN account ON grant_access.account_id = account.id\n" +
                    "                    INNER JOIN role ON grant_access.role_id = role.id WHERE account.id = ?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                grantAccess = new GrantAccess(new Account(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getInt(6)),
                        new Role(rs.getInt(8), rs.getString(7)), rs.getInt(9)
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return grantAccess;
    }


    public void updateAccount(Account ac) {
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement("UPDATE account set full_name =? , password = ?,email =?, phone = ? , status = ? " +
                    "where id = ?");
            statement.setString(1, ac.getFull_name());
            statement.setString(2, ac.getPassword());
            statement.setString(3, ac.getEmail());
            statement.setString(4, ac.getPhone());
            statement.setInt(5, ac.getStatus());
            statement.setInt(6, ac.getAccount_Id());
            int rowsInserted = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateAccountStaff(Account ac) {
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement("UPDATE account set status = ? " +
                    "where id = ?");
            statement.setInt(1, ac.getStatus());
            statement.setInt(2, ac.getAccount_Id());
            int rowsInserted = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateGrantaccessStaff(GrantAccess access) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("UPDATE grant_access set role_id = ? , is_grant = ? " +
                    "where account_id = ?");
            statement.setInt(1, access.getRole().getRole_Id());
            statement.setInt(2, access.getIs_grant());
            statement.setInt(3, access.getAccount().getAccount_Id());
            int rowsInserted = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateGrantaccess(GrantAccess access) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("UPDATE grant_access set role_id = ? , is_grant = ? " +
                    "where account_id = ?");
            statement.setInt(1, access.getRole().getRole_Id());
            statement.setInt(2, access.getIs_grant());
            statement.setInt(3, access.getAccount().getAccount_Id());
            int rowsInserted = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteAccount(Account ac) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("Delete from account where id = ?");
            statement.setInt(1, ac.getAccount_Id());
            int rowsInserted = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deletegrantAccount(GrantAccess grantAccess) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("Delete from grant_access where account_id = ?");
            statement.setInt(1, grantAccess.getAccount().getAccount_Id());
            int rowsInserted = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Role> getAllRole() {
        PreparedStatement statement = null;
        List<Role> dsRole = new ArrayList<>();
        try {
            statement = connection.prepareStatement("SELECT * from role");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Role role = new Role(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));

                dsRole.add(role);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dsRole;
    }

    public void createRole(Role role) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO role VALUES (?,?,?,?)");
            statement.setInt(1, role.getRole_Id());
            statement.setString(2, role.getRole_name());
            statement.setString(3, role.getDescription());
            statement.setInt(4, role.getStatus());
            int rowsInserted = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteRole(Role role) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("Delete from role where id = ?");
            statement.setInt(1, role.getRole_Id());
            int rowsInserted = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateRole(Role role) {
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement("UPDATE role set role_name =? , description = ?,status = ? " +
                    "where id = ?");
            statement.setString(1, role.getRole_name());
            statement.setString(2, role.getDescription());
            statement.setInt(3, role.getStatus());
            statement.setInt(4, role.getRole_Id());
            int rowsInserted = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Role getRole(int id) {
        PreparedStatement statement = null;
        Role role = null;
        try {
            statement = connection.prepareStatement("SELECT * from role where id = ?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                role = new Role(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return role;
    }

    public void updateDeleteRow(Role role) {
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement("UPDATE role set status = ? " +
                    "where id = ?");
            statement.setInt(1, role.getStatus());
            statement.setInt(2, role.getRole_Id());
            int rowsInserted = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Log> getAllLog() {
        PreparedStatement statement = null;
        List<Log> dsLog = new ArrayList<>();
        try {
            statement = connection.prepareStatement("SELECT * from log");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Log log = new Log(rs.getInt(1), new Account(rs.getInt(2), null, null, null, null, 0), rs.getTimestamp(3), rs.getTimestamp(4), rs.getString(5));
                dsLog.add(log);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dsLog;
    }

    public void createLog(Log log) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO log VALUES (?,?,?,?,?)");
            statement.setInt(1, log.getId());
            statement.setInt(2, log.getAccount_log().getAccount_Id());
            statement.setTimestamp(3, log.getTime_log());
            statement.setTimestamp(4, log.getTime_logout());
            statement.setString(5, log.getNode());
            int rowsInserted = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteLog(Log log) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("Delete from log where id = ?");
            statement.setInt(1, log.getId());
            int rowsInserted = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateLog(Log log) {
        PreparedStatement statement = null;

        try {
            statement = connection.prepareStatement("UPDATE log set time_logout =? " +
                    "where id = ?");
            statement.setTimestamp(1, log.getTime_logout());
            statement.setInt(2, log.getId());
            int rowsInserted = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Log> getAlllogAcount() {
        PreparedStatement statement = null;
        List<Log> dsLog = new ArrayList<>();
        try {
            statement = connection.prepareStatement("SELECT log.id,account.id,account.email,log.time_login,log.time_logout \n" +
                    "FROM log INNER JOIN account ON `log`.account_login = account.id");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Log log = new Log(rs.getInt(1), new Account(rs.getInt(2), null, null, rs.getString(3), null, 0), rs.getTimestamp(4), rs.getTimestamp(5), null);
                dsLog.add(log);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dsLog;
    }

}
