package com.example.servlet;


import java.io.IOException;

import com.example.dao.CourseDao;
import com.example.model.Course;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/editCourse")
public class EditCourseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int courseId = Integer.parseInt(request.getParameter("id"));
        CourseDao dao = new CourseDao();
        try {
            Course course = dao.getCourse(courseId);
            request.setAttribute("course", course);
            request.getRequestDispatcher("/editCourse.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("errorMessage", "Error loading course for edit");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int courseId = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String category = request.getParameter("category");
        String level = request.getParameter("level");
        int instructorId = 0; 

        Course course = new Course(courseId, title, description, instructorId, category, level);
        CourseDao dao = new CourseDao();
        try {
            dao.updateCourse(course);
    
            response.sendRedirect(request.getContextPath() + "/instructorDashboard");
        } catch (Exception e) {
            request.setAttribute("errorMessage", "Error updating course");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}
