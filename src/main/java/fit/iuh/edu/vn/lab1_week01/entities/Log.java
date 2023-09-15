package fit.iuh.edu.vn.lab1_week01.entities;

import java.sql.Timestamp;

public class Log {
    private int id;
    private Account account_log;
    private Timestamp time_log;
    private Timestamp time_logout;
    private String node;

    public Log(int id, Account account_log, Timestamp time_log, Timestamp time_logout, String node) {
        this.id = id;
        this.account_log = account_log;
        this.time_log = time_log;
        this.time_logout = time_logout;
        this.node = node;
    }

    public Log() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getAccount_log() {
        return account_log;
    }

    public void setAccount_log(Account account_log) {
        this.account_log = account_log;
    }

    public Timestamp getTime_log() {
        return time_log;
    }

    public void setTime_log(Timestamp time_log) {
        this.time_log = time_log;
    }

    public Timestamp getTime_logout() {
        return time_logout;
    }

    public void setTime_logout(Timestamp time_logout) {
        this.time_logout = time_logout;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", account_log=" + account_log +
                ", time_log=" + time_log +
                ", time_logout=" + time_logout +
                ", node='" + node + '\'' +
                '}';
    }
}
