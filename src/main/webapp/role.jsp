<%@ page import="java.util.List" %>
<%@ page import="fit.iuh.edu.vn.lab1_week01.entities.Role" %>
<%@ page import="fit.iuh.edu.vn.lab1_week01.entities.GrantAccess" %>
<%@ page import="fit.iuh.edu.vn.lab1_week01.entities.Log" %><%--
  Created by IntelliJ IDEA.
  User: phuon
  Date: 9/15/2023
  Time: 8:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">

</head>
<body>
<div class="container">
    <div class="row">
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
        <h1 align="center">Create Role</h1>

        <div class="col-12 mt-4">
            <table class="table">
                <thead class="table-light">
                <tr>
                    <th scope="col">id</th>
                    <th scope="col">role name</th>
                    <th scope="col">status</th>
                    <th scope="col">action</th>
                </tr>
                </thead>
                <tbody>
                <%
                    List<Role> dsRole = (List<Role>) session.getAttribute("dsrole");
                %>
                <%
                    for (int i = 0; i < dsRole.size(); i++) {
                        Role role = dsRole.get(i);
                %>
                <tr>
                    <td><%=role.getRole_Id()%>
                    </td>
                    <td><%=role.getRole_name()%>
                    </td>
                    <td>
                        <%=(role.getStatus() == 1) ? "active" :
                                (role.getStatus() == 0) ? "deactive" :
                                        (role.getStatus() == -1) ? "delete" : "null"
                        %>
                    </td>
                    <td class="d-flex">
                        <form action="control" method="post">
                            <input type="hidden" name="action" value="deleterole">
                            <input type="hidden" name="roleId" value="<%=role.getRole_Id()%>">
                            <button class="btn btn-primary bi bi-trash"
                                    name="delete">Delete
                            </button>
                        </form>
                        <form action="control" method="post">
                            <input type="hidden" name="action" value="updaterole">
                            <input type="hidden" name="roleId" value="<%=role.getRole_Id()%>">
                            <button class="btn btn-warning bi bi-pencil-square"
                                    name="update">
                                Update
                            </button>
                        </form>

                    </td>
                </tr>
                <%
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>
