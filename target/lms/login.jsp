<!DOCTYPE html>
<html>
<head>
    <title>User Login</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
    <style>
        body {background:#f4f4f4;}
        .box {margin:60px auto; width:350px; padding:30px; background:white; border-radius:8px; box-shadow:0 0 12px rgba(0,0,0,.20);}
        .box input, .box button {width:100%; margin-top:10px;}
        .error {color:red; text-align:center; font-size:14px;}
    </style>
</head>
<body>
<jsp:include page="header.jsp" />
<div class="box">
    <h2 style="text-align:center;">Login</h2>
    <form action="login" method="post">
        <div class="mb-3 input-group">
            <span class="input-group-text"><i class="bi bi-envelope"></i></span>
            <input type="email" name="email" placeholder="Email" class="form-control" required />
        </div>
        <div class="mb-3 input-group">
            <span class="input-group-text"><i class="bi bi-lock"></i></span>
            <input type="password" name="password" placeholder="Password" class="form-control" required />
        </div>
        <button type="submit" class="btn btn-primary">Login</button>
        <% if (request.getAttribute("error") != null) { %>
            <p class="error"><%= request.getAttribute("error") %></p>
        <% } %>
    </form>
</div>
</body>
</html>
