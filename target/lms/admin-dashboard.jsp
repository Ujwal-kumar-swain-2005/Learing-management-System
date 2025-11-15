<%@ page import="com.example.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
</head>

<body class="bg-light">

<%
    User user = (User) session.getAttribute("user");
    if (user == null || !"ADMIN".equalsIgnoreCase(user.getRole())) {
        response.sendRedirect("error.jsp");
        return;
    }
%>

<div class="container mt-5">
    <div class="card shadow">
        <div class="card-body">

            <h2 class="text-center">Admin Dashboard</h2>
            <hr>

            <h4>Welcome, <%= user.getName() %> 👋</h4>
            <p><strong>Email:</strong> <%= user.getEmail() %></p>

            <hr>

            <a href="courses" class="btn btn-primary w-100 mt-2">Manage Courses</a>
            <a href="registerInstructor" class="btn btn-secondary w-100 mt-2">Add Instructor</a>
            <a href="registerUser" class="btn btn-info w-100 mt-2">Add User</a>
            <a href="logout" class="btn btn-danger w-100 mt-3">Logout</a>

        </div>
    </div>
</div>

</body>
</html>
