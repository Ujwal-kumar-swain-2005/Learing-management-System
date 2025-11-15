<nav class="navbar navbar-expand-lg navbar-light bg-white shadow-sm mb-3">
  <div class="container">
    <a class="navbar-brand fw-bold" href="${pageContext.request.contextPath}/">YourLMS</a>
    <div class="d-flex">
      <a href="${pageContext.request.contextPath}/courses" class="nav-link">Courses</a>
      <a href="${pageContext.request.contextPath}/logout" class="nav-link text-danger">Logout</a>
    </div>
  </div>
</nav>
<style>
        .card-title {
            white-space: nowrap;
            overflow: hidden;
            text-overflow: ellipsis;
        }
        .truncate-desc {
            display: -webkit-box;
            -webkit-line-clamp: 3;
            -webkit-box-orient: vertical;
            overflow: hidden;
            min-height: 60px;
        }
    </style>