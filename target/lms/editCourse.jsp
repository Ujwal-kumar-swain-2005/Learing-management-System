<%@ page import="com.example.model.Course" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Course</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
</head>
<body class="bg-light">

<jsp:include page="header.jsp" />

<div class="container mt-5">
    <div class="card shadow-lg p-4 col-md-6 mx-auto">
        <h3 class="text-center mb-4">Edit Course</h3>
        <%
            Course course = (Course) request.getAttribute("course");
            if (course == null) {
        %>
            <div class="alert alert-danger">Course not found.</div>
        <% } else { %>
        <form action="${pageContext.request.contextPath}/editCourse?id=<%= course.getId() %>" method="post">
            <div class="mb-3">
                <label for="title" class="form-label">Course Title</label>
                <input type="text" id="title" name="title" class="form-control" required value="<%= course.getTitle() %>">
            </div>
            <div class="mb-3">
                <label for="description" class="form-label">Description</label>
                <textarea id="description" name="description" class="form-control" required><%= course.getDescription() %></textarea>
            </div>
            <div class="mb-3">
                <label for="category" class="form-label">Category</label>
                <input type="text" id="category" name="category" class="form-control" required value="<%= course.getCategory() %>">
            </div>
            <div class="mb-3">
                <label for="level" class="form-label">Level</label>
                <input type="text" id="level" name="level" class="form-control" required value="<%= course.getLevel() %>">
            </div>
            <button type="submit" class="btn btn-primary w-100">Update Course</button>
        </form>
        <% } %>
    </div>
</div>

</body>
</html>
