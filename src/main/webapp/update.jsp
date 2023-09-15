<%@ page import="fit.iuh.edu.vn.lab1_week01.entities.GrantAccess" %><%--
  Created by IntelliJ IDEA.
  User: phuon
  Date: 9/14/2023
  Time: 7:59 PM
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
</head>
<body>
<div class="container">
    <div class="row d-flex align-items-center justify-content-center">
        <div class="col-4">
            <h1 align="center">Update tài khoản</h1>
            <%GrantAccess grantAccess = (GrantAccess) session.getAttribute("accountupdate");%>
            <form action="control" method="post">
                <div class="row">
                    <div class="col-12">

                        <input class="form-control" type="hidden" name="accountId"
                               value="<%=grantAccess.getAccount().getAccount_Id()%>">
                    </div>
                    <div class="col-12">
                        <label class="form-label">fullName:</label>
                        <input class="form-control" type="text" name="fullnames"
                               value="<%=grantAccess.getAccount().getFull_name()%>">
                    </div>
                    <div class="col-12">
                        <label class="form-label">Phone:</label>
                        <input class="form-control" type="text" name="phones"
                               value="<%=grantAccess.getAccount().getPhone()%>">
                    </div>
                    <div class="col-12">
                        <label class="form-label">Email:</label>
                        <input class="form-control" type="email" name="emails"
                               value="<%=grantAccess.getAccount().getEmail()%>">
                    </div>
                    <div class="col-12">
                        <label class="form-label">Password:</label>
                        <input class="form-control" type="password" name="passwords"
                               value="<%=grantAccess.getAccount().getPassword()%>">
                    </div>
                    <div class="col-12">
                        <label class="form-label">Status:</label>
                        <select class="form-select" aria-label="Default select example" name="statuss">
                            <option value="1" <%=grantAccess.getAccount().getStatus() == 1 ? "selected" : ""%>>
                                active
                            </option>
                            <option value="0" <%=grantAccess.getAccount().getStatus() == 0 ? "selected" : ""%>>
                                deactive
                            </option>
                            <option value="-1" <%=grantAccess.getAccount().getStatus() == -1 ? "selected" : ""%>>
                                delete
                            </option>
                        </select>
                    </div>
                    <%
                        GrantAccess gr = (GrantAccess) session.getAttribute("user");
                        if (gr.getRole().getRole_Id() == 1) {
                    %>
                    <div class="col-12">
                        <label class="form-label">Role:</label>
                        <select class="form-select" aria-label="Default select example" name="roles">
                            <option value="1" <%=grantAccess.getRole().getRole_Id() == 1 ? "selected" : ""%>>Manager
                            </option>
                            <option value="2" <%=grantAccess.getRole().getRole_Id() == 2 ? "selected" : ""%>>Staff
                            </option>
                            <option value="3" <%=grantAccess.getRole().getRole_Id() == 3 ? "selected" : ""%>>Customer
                            </option>
                        </select>
                    </div>
                    <%
                        } else if (gr.getRole().getRole_Id() == 2) {
                        }
                    %>
                    <div class="col-12 mt-3">
                        <%
                            if (gr.getRole().getRole_Id() == 1) {
                        %>
                        <input type="hidden" name="action" value="saveupdate">
                        <%
                        } else if (gr.getRole().getRole_Id() == 2) {

                        %>
                        <input type="hidden" name="action" value="saveupdatestaff">
                        <%
                            }
                        %>
                        <button class="btn btn-danger w-100" name="saveupdate">Save update</button>
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
