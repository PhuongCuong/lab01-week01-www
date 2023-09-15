<%@ page import="fit.iuh.edu.vn.lab1_week01.entities.GrantAccess" %>
<%@ page import="fit.iuh.edu.vn.lab1_week01.entities.Log" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: phuon
  Date: 9/14/2023
  Time: 11:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">

</head>
<body>
<div class="container">
    <div class="row d-flex align-items-center justify-content-center">
        <nav class="navbar navbar-expand-lg bg-body-tertiary">
            <div class="container-fluid">
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                        aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" href="dashboard.jsp">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="create.jsp">Create Account</a>
                        </li>
                        <%
                            GrantAccess gr = (GrantAccess) session.getAttribute("user");
                            if (gr.getRole().getRole_Id() == 1) {
                        %>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                               aria-expanded="false">
                                Role
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="role.jsp">Role Manage</a></li>
                                <li><a class="dropdown-item" href="createrole.jsp">Create Role</a></li>
                            </ul>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="log.jsp">Log</a>
                        </li>
                        <%
                            } else if (gr.getRole().getRole_Id() == 2) {
                            }
                        %>
                    </ul>
                </div>
                <form class="d-flex ml-auto" role="search" action="control" method="post">
                    <%
                        List<Log> dslog = (List<Log>) session.getAttribute("dslogid");
                        Log log = dslog.get(dslog.size() - 1);
                    %>
                    <input type="hidden" name="accountlogId" value="<%=log.getId()%>">
                    <input type="hidden" name="action" value="logout">
                    <button class="btn btn-outline-success bi bi-power" type="submit">Log out</button>
                </form>
            </div>
        </nav>
        <div class="col-4">
            <h1 align="center">Tạo tài khoản</h1>
            <form action="control" method="post">
                <div class="row">
                    <div class="col-12">
                        <label class="form-label">Account ID:</label>
                        <input class="form-control" type="text" name="accountId">
                    </div>
                    <div class="col-12">
                        <label class="form-label">fullName:</label>
                        <input class="form-control" type="text" name="fullname">
                    </div>
                    <div class="col-12">
                        <label class="form-label">Phone:</label>
                        <input class="form-control" type="text" name="phone">
                    </div>
                    <div class="col-12">
                        <label class="form-label">Email:</label>
                        <input class="form-control" type="email" name="email">
                    </div>
                    <div class="col-12">
                        <label class="form-label">Password:</label>
                        <input class="form-control" type="password" name="password">
                    </div>
                    <div class="col-12">
                        <label class="form-label">Status:</label>
                        <select class="form-select" aria-label="Default select example" name="status">
                            <option value="1" selected>active</option>
                            <option value="0">deactive</option>
                            <option value="-1">delete</option>
                        </select>
                    </div>
                    <%
                        if (gr.getRole().getRole_Id() == 1) {
                    %>
                    <div class="col-12">
                        <label class="form-label">Role:</label>
                        <select class="form-select" aria-label="Default select example" name="role">
                            <option value="1" selected>Manager</option>
                            <option value="2">Staff</option>
                            <option value="3">Customer</option>
                        </select>
                    </div>
                    <%
                    } else if (gr.getRole().getRole_Id() == 2) {
                    %>
                    <div class="col-12">
                        <label class="form-label">Role:</label>
                        <select class="form-select" aria-label="Default select example" name="role">
                            <option value="3" selected>Customer</option>
                        </select>
                    </div>
                    <%
                        }
                    %>
                    <div class="col-12 mt-3">
                        <%
                            if (gr.getRole().getRole_Id() == 1) {
                        %>
                        <input type="hidden" name="action" value="save">
                        <%
                        } else if (gr.getRole().getRole_Id() == 2) {
                        %>
                        <input type="hidden" name="action" value="savestaff">
                        <%
                            }
                        %>
                        <button class="btn btn-danger w-100" name="save">Save</button>
                    </div>
                </div>
            </form>

        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
        crossorigin="anonymous"></script>
</body>
</html>
