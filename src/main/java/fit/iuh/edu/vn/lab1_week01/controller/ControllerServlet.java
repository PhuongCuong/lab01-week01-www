package fit.iuh.edu.vn.lab1_week01.controller;

import fit.iuh.edu.vn.lab1_week01.entities.Account;
import fit.iuh.edu.vn.lab1_week01.entities.GrantAccess;
import fit.iuh.edu.vn.lab1_week01.entities.Log;
import fit.iuh.edu.vn.lab1_week01.entities.Role;
import fit.iuh.edu.vn.lab1_week01.respositories.AccountRespository;
import fit.iuh.edu.vn.lab1_week01.respositories.DataBase;
import fit.iuh.edu.vn.lab1_week01.services.AccountServices;
import fit.iuh.edu.vn.lab1_week01.services.LogServices;
import fit.iuh.edu.vn.lab1_week01.services.RoleServices;
import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.List;

@WebServlet(urlPatterns = {"/control","/controlSerlet"})
public class ControllerServlet extends HttpServlet {
    @Inject
    private AccountServices services;
    @Inject
    private RoleServices roleServices;

    @Inject
    private LogServices logServices;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        PrintWriter out = resp.getWriter();
        GrantAccess ac = services.getAccountRole(email, password);
        List<GrantAccess> dsAccount = services.getAllAcountRole();

        List<Role> dsRole = roleServices.getAllrole();

        if (ac == null) {
            out.println("Đăng nhập thất bại");
        } else {
            HttpSession session = req.getSession();
            session.setAttribute("user", services.getAccountRole(email, password));
            session.setAttribute("dsuser", services.getAllAcountRole());
            session.setAttribute("dsuserStaff", services.getAllAccountRoleStaff());
            session.setAttribute("getAlllog", logServices.getAllLogAccount());
            Log log = new Log();
            log.setAccount_log(new Account(ac.getAccount().getAccount_Id()));
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            log.setTime_log(timestamp);
            logServices.createLog(log);
            session.setAttribute("dslogid", logServices.getAllLog());
            resp.sendRedirect("dashboard.jsp");
            String save = req.getParameter("save");
            if (save != null) {
                session.setAttribute("user", services.getAccountRole(email, password));
                session.setAttribute("dsuser", services.getAllAcountRole());
                resp.sendRedirect("dashboard.jsp");
            }
        }

        if (dsRole.size() > 0) {
            HttpSession session = req.getSession();
            session.setAttribute("dsrole", roleServices.getAllrole());
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equalsIgnoreCase("save")) {
            int id = Integer.parseInt(req.getParameter("accountId"));
            String fullname = req.getParameter("fullname");
            String phone = req.getParameter("phone");
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            int status = Integer.parseInt(req.getParameter("status"));
            int role = Integer.parseInt(req.getParameter("role"));

            Account ac = new Account(id, fullname, password, email, phone, status);
            Role rol = new Role();
            rol.setRole_Id(role);
            GrantAccess gr = new GrantAccess(ac, rol, 1, "");
            resp.getWriter().println("handle Save" + ac);
            services.createAccount(ac);
            if (ac != null) {
                services.creategrantaccount(gr);
                HttpSession session = req.getSession();
                session.setAttribute("dsuser", services.getAllAcountRole());
                resp.sendRedirect("dashboard.jsp");
            }
        } else if (action.equalsIgnoreCase("update")) {
            int accountId = Integer.parseInt(req.getParameter("accountid"));
            HttpSession session = req.getSession();
            session.setAttribute("accountupdate", services.getAccountUpdate(accountId));
            resp.sendRedirect("update.jsp");

        } else if (action.equalsIgnoreCase("delete")) {
            int accountId = Integer.parseInt(req.getParameter("accountid"));
            GrantAccess access = new GrantAccess();
            Account ac = new Account();
            ac.setAccount_Id(accountId);
            access.setAccount(ac);
            services.deleteGrantAccount(access);
            services.deleteAccount(ac);
            HttpSession session = req.getSession();
            session.setAttribute("dsuser", services.getAllAcountRole());
            resp.sendRedirect("dashboard.jsp");

        } else if (action.equalsIgnoreCase("saveupdate")) {
            int accountId = Integer.parseInt(req.getParameter("accountId"));
            Account ac = new Account();
            ac.setAccount_Id(accountId);
            ac.setFull_name(req.getParameter("fullnames"));
            ac.setEmail(req.getParameter("emails"));
            ac.setPhone(req.getParameter("phones"));
            ac.setPassword(req.getParameter("passwords"));
            ac.setStatus(Integer.parseInt(req.getParameter("statuss")));
            services.updateAccount(ac);
            Role role = new Role();
            role.setRole_Id(Integer.parseInt(req.getParameter("roles")));
            GrantAccess access = new GrantAccess(ac, role, 1);
            services.updateGrantaccount(access);
            HttpSession session = req.getSession();
            session.setAttribute("dsuser", services.getAllAcountRole());
            resp.sendRedirect("dashboard.jsp");
        } else if (action.equalsIgnoreCase("saverole")) {
            String roleName = req.getParameter("rolename");
            int status = Integer.parseInt(req.getParameter("statusrole"));
            Role role = new Role();
            role.setRole_name(roleName);
            role.setStatus(status);
            roleServices.createRole(role);
            HttpSession session = req.getSession();
            session.setAttribute("dsrole", roleServices.getAllrole());
            resp.sendRedirect("role.jsp");
        } else if (action.equalsIgnoreCase("updaterole")) {
            int roleId = Integer.parseInt(req.getParameter("roleId"));
            roleServices.getRole(roleId);
            HttpSession session = req.getSession();
            session.setAttribute("datarole", roleServices.getRole(roleId));
            resp.sendRedirect("updaterole.jsp");
        } else if (action.equalsIgnoreCase("saveroleupdate")) {
            int roleId = Integer.parseInt(req.getParameter("roleId"));
            String roleName = req.getParameter("rolename");
            int status = Integer.parseInt(req.getParameter("statusrole"));
            Role role = new Role();
            role.setRole_Id(roleId);
            role.setRole_name(roleName);
            role.setStatus(status);
            roleServices.updateRole(role);
            HttpSession session = req.getSession();
            session.setAttribute("dsrole", roleServices.getAllrole());
            resp.sendRedirect("role.jsp");
        } else if (action.equalsIgnoreCase("deleterole")) {
            int roleId = Integer.parseInt(req.getParameter("roleId"));
            Role role = new Role();
            role.setRole_Id(roleId);
            role.setStatus(-1);
            roleServices.updateDeleteRow(role);
            HttpSession session = req.getSession();
            session.setAttribute("dsrole", roleServices.getAllrole());
            resp.sendRedirect("role.jsp");
        } else if (action.equalsIgnoreCase("logout")) {
            Log log = new Log();
            int accountId = Integer.parseInt(req.getParameter("accountlogId"));
            log.setId(accountId);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            log.setTime_logout(timestamp);
            logServices.updateLog(log);
            resp.sendRedirect("index.jsp");
        } else if (action.equalsIgnoreCase("deletestaff")) {
            int accountId = Integer.parseInt(req.getParameter("accountid"));
            Account account = new Account();
            account.setAccount_Id(accountId);
            account.setStatus(-1);
            services.updateAccountStaff(account);
            HttpSession session = req.getSession();
            session.setAttribute("dsuserStaff", services.getAllAccountRoleStaff());
            resp.sendRedirect("dashboard.jsp");
        } else if (action.equalsIgnoreCase("savestaff")) {
            int id = Integer.parseInt(req.getParameter("accountId"));
            String fullname = req.getParameter("fullname");
            String phone = req.getParameter("phone");
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            int status = Integer.parseInt(req.getParameter("status"));
            int role = Integer.parseInt(req.getParameter("role"));

            Account ac = new Account(id, fullname, password, email, phone, status);
            Role rol = new Role();
            rol.setRole_Id(role);
            GrantAccess gr = new GrantAccess(ac, rol, 1, "");
            resp.getWriter().println("handle Save" + ac);
            services.createAccount(ac);
            if (ac != null) {
                services.creategrantaccount(gr);
                HttpSession session = req.getSession();
                session.setAttribute("dsuserStaff", services.getAllAccountRoleStaff());
                resp.sendRedirect("dashboard.jsp");
            }
        } else if (action.equalsIgnoreCase("saveupdatestaff")) {
            int accountId = Integer.parseInt(req.getParameter("accountId"));
            Account ac = new Account();
            ac.setAccount_Id(accountId);
            ac.setFull_name(req.getParameter("fullnames"));
            ac.setEmail(req.getParameter("emails"));
            ac.setPhone(req.getParameter("phones"));
            ac.setPassword(req.getParameter("passwords"));
            ac.setStatus(Integer.parseInt(req.getParameter("statuss")));
            services.updateAccount(ac);
            Role role = new Role();
            role.setRole_Id(3);
            GrantAccess access = new GrantAccess(ac, role, 1);
            services.updateGrantaccount(access);
            HttpSession session = req.getSession();
            session.setAttribute("dsuserStaff", services.getAllAccountRoleStaff());
            resp.sendRedirect("dashboard.jsp");
        }

    }

}
