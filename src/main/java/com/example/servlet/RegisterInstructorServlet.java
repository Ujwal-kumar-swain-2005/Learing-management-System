package com.example.servlet;
import java.io.IOException;

import com.example.dao.InstructorDao;
import com.example.model.Instructor;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/registerInstructor")
public class RegisterInstructorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.sendRedirect(request.getContextPath() + "/instructor-form.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = "INSTRUCTOR";  
        String employeeId = request.getParameter("employeeId");
        String specialization = request.getParameter("specialization");

        Instructor instructor = new Instructor();
        instructor.setName(name);
        instructor.setEmail(email);
        instructor.setPassword(password);
        instructor.setRole(role);
        instructor.setEmployeeId(employeeId);
        instructor.setSpecialization(specialization);
       InstructorDao instructorDao = new InstructorDao();
        try {
            instructorDao.saveInstructor(instructor);

            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().println("<h2>Instructor Registered Successfully</h2>");
            response.getWriter().println("<p>Name: " + name + "</p>");
            response.getWriter().println("<p>Email: " + email + "</p>");
            response.getWriter().println("<p>Employee ID: " + employeeId + "</p>");
            response.getWriter().println("<p>Specialization: " + specialization + "</p>");

        } catch (Exception e) {
            throw new ServletException("Error saving instructor", e);
        }
    }
}

