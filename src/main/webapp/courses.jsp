<%@ page import="java.util.List" %>
<%@ page import="com.example.model.Course" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>All Courses</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
    <style>
        .card-title {
            white-space: nowrap;
            overflow: hidden;
            text-overflow: ellipsis;
        }
        .truncate-desc {
            display: -webkit-box; -webkit-line-clamp: 3; -webkit-box-orient: vertical;
            overflow: hidden; min-height: 60px;
        }
        .card:hover { box-shadow: 0 0 18px 0 rgba(52,128,158,0.2); transform: scale(1.01);}
    </style>
</head>
<body class="bg-light">

<jsp:include page="header.jsp" />

<div class="container py-5">
    <div class="d-flex justify-content-between align-items-center mb-4">
        <h2 class="text-center flex-grow-1 mb-0">Available Courses</h2>
        <a href="${pageContext.request.contextPath}/course-form.jsp"
           class="btn btn-success ms-3">
            <i class="bi bi-plus-lg"></i> Add New Course
        </a>
    </div>

    <div class="row g-4">
        <%
            List<Course> courses = (List<Course>) request.getAttribute("courses");
            if (courses != null && !courses.isEmpty()) {
                for (Course c : courses) {
        %>
        <div class="col-md-6 col-lg-4 d-flex">
            <div class="card shadow-sm w-100 h-100">
                <div class="card-body d-flex flex-column">
                    <h5 class="card-title" title="<%= c.getTitle() %>"><%= c.getTitle() %></h5>
                    <p class="card-text mb-2 truncate-desc" title="<%= c.getDescription() %>"><%= c.getDescription() %></p>
                    <div class="mb-2">
                        <span class="badge bg-info"><i class="bi bi-tag"></i> <%= c.getCategory() %></span>
                        <span class="badge bg-secondary"><i class="bi bi-layers"></i> <%= c.getLevel() %></span>
                    </div>
                    <p class="text-muted small"><i class="bi bi-person"></i>
                        <strong>Instructor:</strong> <%= c.getInstructorId() %>
                    </p>
                    <div class="mt-auto d-flex justify-content-between">
                        <a href="editCourse?id=<%= c.getId() %>" class="btn btn-outline-primary btn-sm">
                            <i class="bi bi-pencil"></i> Edit
                        </a>
                        <a href="deleteCourse?id=<%= c.getId() %>" class="btn btn-outline-danger btn-sm"
                           onclick="return confirm('Are you sure you want to delete?');">
                            <i class="bi bi-trash"></i> Delete
                        </a>
                    </div>
                </div>
            </div>
        </div>
        <%      }
            } else {  %>
        <div class="col-12">
            <p class="text-center text-muted">No courses available.</p>
        </div>
        <% } %>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
