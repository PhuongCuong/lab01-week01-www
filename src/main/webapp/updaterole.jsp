<%@ page import="fit.iuh.edu.vn.lab1_week01.entities.Role" %><%--
  Created by IntelliJ IDEA.
  User: phuon
  Date: 9/15/2023
  Time: 8:40 AM
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
</head>
<body>
<div class="container">
    <div class="row d-flex align-items-center justify-content-center">
        <div class="col-4">
            <h1 align="center">Create Role</h1>
            <%
                Role role = (Role) session.getAttribute("datarole");
            %>
            <form action="control" method="post">
                <div class="row">
                    <div class="col-12">
                        <input class="form-control" type="hidden" name="roleId" value="<%=role.getRole_Id()%>">
                    </div>
                    <div class="col-12">
                        <label class="form-label">role name:</label>
                        <input class="form-control" type="text" name="rolename" value="<%=role.getRole_name()%>">
                    </div>
                    <div class="col-12">
                        <label class="form-label">Status:</label>
                        <select class="form-select" aria-label="Default select example" name="statusrole">
                            <option value="1" <%=role.getStatus() == 1 ? "selected" : ""%>>
                                active
                            </option>
                            <option value="0" <%=role.getStatus() == 0 ? "selected" : ""%>>
                                deactive
                            </option>
                            <option value="-1" <%=role.getStatus() == -1 ? "selected" : ""%>>
                                delete
                            </option>
                        </select>
                    </div>
                    <div class="col-12 mt-3">
                        <input type="hidden" name="action" value="saveroleupdate">
                        <button class="btn btn-danger w-100" name="saveroleupdate">Save update</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
</body>
</html>
