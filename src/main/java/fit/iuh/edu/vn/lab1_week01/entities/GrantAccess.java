package fit.iuh.edu.vn.lab1_week01.entities;

public class GrantAccess {
    private Account account;
    private Role role;
    private int is_grant;
    private String node;

    public GrantAccess(Account account, Role role, int is_grant, String node) {
        this.account = account;
        this.role = role;
        this.is_grant = is_grant;
        this.node = node;
    }

    public GrantAccess(Account account, Role role, int is_grant) {
        this.account = account;
        this.role = role;
        this.is_grant = is_grant;
    }

    public GrantAccess() {
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getIs_grant() {
        return is_grant;
    }

    public void setIs_grant(int is_grant) {
        this.is_grant = is_grant;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    @Override
    public String toString() {
        return "GrantAccess{" +
                "account=" + account +
                ", role=" + role +
                ", is_grant=" + is_grant +
                ", node='" + node + '\'' +
                '}';
    }
}
