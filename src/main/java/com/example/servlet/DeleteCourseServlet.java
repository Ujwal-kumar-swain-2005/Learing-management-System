package com.example.servlet;
import java.io.IOException;

import com.example.dao.CourseDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteCourse")
public class DeleteCourseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            
            int id = Integer.parseInt(request.getParameter("id"));

            CourseDao dao = new CourseDao();
            dao.deleteCourse(id);

            response.sendRedirect(request.getContextPath() + "/courses");

        } catch (Exception e) {
            throw new ServletException("Error deleting course", e);
        }
    }
}
