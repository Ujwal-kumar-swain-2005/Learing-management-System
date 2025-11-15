<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>User Registration</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
</head>
<body class="bg-light">

<jsp:include page="header.jsp" />

<div class="container mt-5">
  <div class="card shadow-lg p-4 col-md-6 mx-auto">
    <h3 class="text-center mb-4">User Registration</h3>
    <% if (request.getAttribute("regSuccess") != null) { %>
      <div class="alert alert-success text-center">
        Registration successful! <a href="courses.jsp" class="alert-link">Go to Courses</a>
      </div>
    <% } %>
    <form action="${pageContext.request.contextPath}/registerUser" method="post">
      <div class="mb-3 input-group">
        <span class="input-group-text"><i class="bi bi-person"></i></span>
        <input type="text" id="name" name="name" class="form-control" placeholder="Enter full name" required>
      </div>
      <div class="mb-3 input-group">
        <span class="input-group-text"><i class="bi bi-envelope"></i></span>
        <input type="email" id="email" name="email" class="form-control" placeholder="Enter email" required>
      </div>
      <div class="mb-3 input-group">
        <span class="input-group-text"><i class="bi bi-lock"></i></span>
        <input type="password" id="password" name="password" class="form-control" placeholder="Enter password" required>
      </div>
      <div class="mb-3">
        <label for="role" class="form-label">Role</label>
        <select id="role" name="role" class="form-select" required>
          <option value="STUDENT" selected>Student</option>
        </select>
      </div>
      <button type="submit" class="btn btn-primary w-100">Register</button>
    </form>
    <div class="text-center mt-3">
      <a href="${pageContext.request.contextPath}/login.jsp">Already have an account? Login</a>
    </div>
  </div>
</div>

</body>
</html>
