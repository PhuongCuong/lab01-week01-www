package fit.iuh.edu.vn.lab1_week01.services;

import fit.iuh.edu.vn.lab1_week01.entities.Log;
import fit.iuh.edu.vn.lab1_week01.respositories.DataBase;
import fit.iuh.edu.vn.lab1_week01.respositories.LogRespository;
import jakarta.inject.Inject;

import java.util.List;

public class LogServices {
    @Inject
    private LogRespository logRespository;


    public List<Log> getAllLog() {
        return logRespository.getAllLog();
    }

    public void createLog(Log log) {
        logRespository.createLog(log);
    }

    public void deleteLog(Log log) {
        logRespository.deleteLog(log);
    }

    public void updateLog(Log log) {
        logRespository.updateLog(log);
    }

    public List<Log> getAllLogAccount() {
        return logRespository.getAllLogAccount();
    }
}
