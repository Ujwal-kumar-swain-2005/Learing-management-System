package com.example.servlet;

import java.io.IOException;
import java.util.List;

import com.example.dao.CourseDao;
import com.example.model.Course;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/courses")
public class CoursesListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        CourseDao dao = new CourseDao();

        try {
           
            List<Course> courseList = dao.getAllCourses();

            request.setAttribute("courses", courseList);

            request.getRequestDispatcher("/courses.jsp").forward(request, response);
        } catch (Exception e) {
           
            e.printStackTrace();
            request.setAttribute("errorMessage", "Unable to fetch courses. Please try again later.");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}
