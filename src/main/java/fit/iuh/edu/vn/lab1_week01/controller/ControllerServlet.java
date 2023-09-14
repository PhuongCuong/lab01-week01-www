package fit.iuh.edu.vn.lab1_week01.controller;

import fit.iuh.edu.vn.lab1_week01.entities.Account;
import fit.iuh.edu.vn.lab1_week01.entities.GrantAccess;
import fit.iuh.edu.vn.lab1_week01.respositories.AccountRespository;
import fit.iuh.edu.vn.lab1_week01.respositories.DataBase;
import fit.iuh.edu.vn.lab1_week01.services.AccountServices;
import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = {"/control","/controlSerlet"})
public class ControllerServlet extends HttpServlet {
    @Inject
    private AccountServices services;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        PrintWriter out = resp.getWriter();
        GrantAccess ac = services.getAccountRole(email, password);
        List<GrantAccess> dsAccount = services.getAllAcountRole();

        if (ac == null) {
            out.println("Đăng nhập thất bại");
        } else {
            RequestDispatcher dispatcher = req.getRequestDispatcher("dashboard.jsp");
            req.setAttribute("user", services.getAccountRole(email, password));
            req.setAttribute("dsuser", services.getAllAcountRole());
            dispatcher.forward(req, resp);
            String deleteBtn = req.getParameter("delete");
            String updateBtn = req.getParameter("update");

            if ("save".equalsIgnoreCase(action)) {
                resp.sendRedirect("dashboard.jsp");
            }

        }

//        if (services.getAccount(email, password) != null) {
//            resp.sendRedirect("dashboard.jsp");
//        } else {
//            resp.getWriter().println("Cút");
//        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
