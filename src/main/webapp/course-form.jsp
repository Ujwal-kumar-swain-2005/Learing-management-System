<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Course</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="card shadow-lg p-4 col-md-6 offset-md-3">
        <h3 class="text-center mb-4">Add New Course</h3>

        <form action="${pageContext.request.contextPath}/addCourse" method="post">

            <div class="mb-3">
                <label class="form-label">Course Title</label>
                <input type="text" name="title" class="form-control" placeholder="Enter course title" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Description</label>
                <textarea name="description" class="form-control" placeholder="Enter course description" required></textarea>
            </div>

            <div class="mb-3">
                <label class="form-label">Instructor ID</label>
                <input type="number" name="instructorId" class="form-control" placeholder="Enter instructor ID" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Category</label>
                <input type="text" name="category" class="form-control" placeholder="e.g. Programming, Design, AI" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Level</label>
                <select name="level" class="form-select" required>
                    <option value="">Select level</option>
                    <option value="BEGINNER">Beginner</option>
                    <option value="INTERMEDIATE">Intermediate</option>
                    <option value="ADVANCED">Advanced</option>
                </select>
            </div>

            <button type="submit" class="btn btn-primary w-100">Add Course</button>
        </form>

        <div class="text-center mt-3">
            <a href="${pageContext.request.contextPath}/dashboard.jsp">Back to Dashboard</a>
        </div>
    </div>
</div>

</body>
</html>
