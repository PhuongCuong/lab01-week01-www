package fit.iuh.edu.vn.lab1_week01.controller;

import fit.iuh.edu.vn.lab1_week01.entities.Log;
import fit.iuh.edu.vn.lab1_week01.services.LogServices;
import jakarta.inject.Inject;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Timestamp;
import java.util.List;

public class ServerShutdownListener implements ServletContextListener {
    @Inject
    private LogServices logServices;

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        Log log = new Log();
        List<Log> dsLog = logServices.getAllLog();
        Log logmax = dsLog.get(dsLog.size() - 1);
        log.setId(logmax.getId());
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        log.setTime_logout(timestamp);
        logServices.updateLog(log);
    }
}
