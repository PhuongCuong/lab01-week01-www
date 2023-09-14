<%@ page import="fit.iuh.edu.vn.lab1_week01.entities.GrantAccess" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: phuon
  Date: 9/13/2023
  Time: 10:14 PM
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
    <!-- Option 1: Include in HTML -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
</head>
<body>
<div class="container">
    <div class="row d-flex align-items-center justify-content-center">
        <%
            GrantAccess gr = (GrantAccess) request.getAttribute("user");
            String updateButtonId = null;
            if (gr.getRole().getRole_Id() == 3) {
        %>
        <h1 align="center">Đăng nhập thành công</h1>
        <table class="table">
            <thead class="table-light">
            <tr>
                <th scope="col">id</th>
                <th scope="col">fullName</th>
                <th scope="col">email</th>
                <th scope="col">phone</th>
                <th scope="col">role</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td><%=gr.getAccount().getAccount_Id()%>
                </td>
                <td><%=gr.getAccount().getFull_name()%>
                </td>
                <td><%=gr.getAccount().getEmail()%>
                </td>
                <td><%=gr.getAccount().getPhone()%>
                </td>
                <td><%=gr.getRole().getRole_name()%>
                </td>

            </tr>
            </tbody>
        </table>
        <%
        } else if (gr.getRole().getRole_Id() == 1) {
        %>
        <h1 align="center">Đăng nhập thành công</h1>
        <div class="row">
            <div class="col-6">
                <label class="form-label">fullName:</label>
                <input class="form-control" type="text" name="fullname">
            </div>
            <div class="col-6">
                <label class="form-label">Phone:</label>
                <input class="form-control" type="text" name="phone">
            </div>
            <div class="col-6">
                <label class="form-label">Email:</label>
                <input class="form-control" type="email" name="email">
            </div>
            <div class="col-6">
                <label class="form-label">Password:</label>
                <input class="form-control" type="password" name="password">
            </div>
            <div class="col-6">
                <label class="form-label">Status:</label>
                <select class="form-select" aria-label="Default select example">
                    <option value="1" selected>active</option>
                    <option value="0">deactive</option>
                    <option value="-1">delete</option>
                </select>
            </div>
            <div class="col-6">
                <label class="form-label">Role:</label>
                <select class="form-select" aria-label="Default select example">
                    <option value="1" selected>Manager</option>
                    <option value="2">Staff</option>
                    <option value="3">Customer</option>
                </select>
            </div>
            <div class="col-12 mt-4">
                <table class="table">
                    <thead class="table-light">
                    <tr>
                        <th scope="col">id</th>
                        <th scope="col">fullName</th>
                        <th scope="col">email</th>
                        <th scope="col">phone</th>
                        <th scope="col">role</th>
                        <th scope="col">status</th>
                        <th scope="col">action</th>

                    </tr>
                    </thead>
                    <tbody>
                    <%List<GrantAccess> dsAccount = (List<GrantAccess>) request.getAttribute("dsuser");%>
                    <%
                        for (int i = 0; i < dsAccount.size(); i++) {
                            GrantAccess grantAccess = dsAccount.get(i);
                            updateButtonId = "btnupdate_" + i;
                            String deleteButtonId = "btndelete_" + i;
                    %>
                    <tr>
                        <td><%=grantAccess.getAccount().getAccount_Id()%>
                        </td>
                        <td><%=grantAccess.getAccount().getFull_name()%>
                        </td>
                        <td><%=grantAccess.getAccount().getEmail()%>
                        </td>
                        <td><%=grantAccess.getAccount().getPhone()%>
                        </td>
                        <td><%=grantAccess.getRole().getRole_name()%>
                        </td>
                        <td><%=(grantAccess.getAccount().getStatus() == 1) ? "active" :
                                (grantAccess.getAccount().getStatus() == 0) ? "deactive" :
                                        (grantAccess.getAccount().getStatus() == -1) ? "xóa" : "null"
                        %>
                        </td>
                        <td>
                            <button class="btn btn-primary bi bi-trash"
                                    onclick=""
                                    name="delete">Delete
                            </button>
                            <button class="btn btn-warning bi bi-pencil-square"
                                    onclick="updateClick(<%grantAccess.getAccount().getEmail();%>)"
                                    name="update">
                                Update
                            </button>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                    </tbody>
                </table>
            </div>
            <div class="col-12">
                <div class="d-flex justify-content-end">
                    <form action="control">
                        <input type="hidden" name="action" value="save">
                        <button class="btn btn-danger">Save</button>
                    </form>
                </div>
            </div>
        </div>
        <%
            }
        %>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
        crossorigin="anonymous"></script>

</body>
</html>
