<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Instructor Registration</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="card shadow-lg p-4 col-md-6 offset-md-3">
        <h3 class="text-center mb-4">Instructor Registration</h3>

        <form action="${pageContext.request.contextPath}/registerInstructor" method="post">

            <div class="mb-3">
                <label class="form-label">Full Name</label>
                <input type="text" name="name" class="form-control" placeholder="Enter full name" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Email Address</label>
                <input type="email" name="email" class="form-control" placeholder="Enter email" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Password</label>
                <input type="password" name="password" class="form-control" placeholder="Enter password" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Employee ID</label>
                <input type="text" name="employeeId" class="form-control" placeholder="Enter employee ID" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Specialization</label>
                <input type="text" name="specialization" class="form-control" placeholder="e.g. Java, ML, Web Dev" required>
            </div>

            <button type="submit" class="btn btn-primary w-100">Register Instructor</button>
        </form>

        <div class="text-center mt-3">
            <a href="${pageContext.request.contextPath}/login.jsp">Already registered? Login</a>
        </div>
    </div>
</div>

</body>
</html>
