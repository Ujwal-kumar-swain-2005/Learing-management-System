<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Error</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
</head>
<body class="bg-light">

<jsp:include page="header.jsp" />

<div class="container mt-5">
    <div class="card shadow-lg p-4 col-md-6 mx-auto">
        <h3 class="text-center text-danger mb-4"><i class="bi bi-exclamation-triangle"></i> Error</h3>
        <p class="text-center">
            <%= request.getAttribute("errorMessage") != null
                ? request.getAttribute("errorMessage")
                : "An unexpected error occurred. Please try again later." %>
        </p>
        <div class="text-center mt-3">
            <a href="${pageContext.request.contextPath}/" class="btn btn-secondary">Go Home</a>
        </div>
    </div>
</div>

</body>
</html>
