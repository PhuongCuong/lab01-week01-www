package fit.iuh.edu.vn.lab1_week01.respositories;

import fit.iuh.edu.vn.lab1_week01.entities.Log;

import java.util.List;

public class LogRespository {
    private DataBase dataBase;

    public LogRespository() {
        dataBase = new DataBase();
    }

    public List<Log> getAllLog() {
        return dataBase.getAllLog();
    }

    public void createLog(Log log) {
        dataBase.createLog(log);
    }

    public void deleteLog(Log log) {
        dataBase.deleteLog(log);
    }

    public void updateLog(Log log) {
        dataBase.updateLog(log);
    }

    public List<Log> getAllLogAccount() {
        return dataBase.getAlllogAcount();
    }
}
