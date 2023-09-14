package fit.iuh.edu.vn.lab1_week01.respositories;

import fit.iuh.edu.vn.lab1_week01.entities.Account;
import fit.iuh.edu.vn.lab1_week01.entities.GrantAccess;
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

}
