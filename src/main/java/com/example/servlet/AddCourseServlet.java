package com.example.servlet;

import java.io.IOException;

import com.example.dao.CourseDao;
import com.example.model.Course;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;   
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest; 
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/addCourse")
public class AddCourseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.sendRedirect(request.getContextPath() + "/course-form.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String title = request.getParameter("title");
        String description = request.getParameter("description");
        int instructorId = Integer.parseInt(request.getParameter("instructorId"));
        String category = request.getParameter("category");
        String level = request.getParameter("level");

        Course course = new Course();
        course.setTitle(title);
        course.setDescription(description);
        course.setInstructorId(instructorId);
        course.setCategory(category);
        course.setLevel(level);

        CourseDao courseDao = new CourseDao();

        try {
            courseDao.saveCourse(course);

            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().println("<h2>Course Added Successfully</h2>");
            response.getWriter().println("<p>Title: " + title + "</p>");
            response.getWriter().println("<p>Description: " + description + "</p>");
            response.getWriter().println("<p>Instructor ID: " + instructorId + "</p>");
            response.getWriter().println("<p>Category: " + category + "</p>");
            response.getWriter().println("<p>Level: " + level + "</p>");

        } catch (Exception e) {
            throw new ServletException("Error saving course", e);
        }
    }
}