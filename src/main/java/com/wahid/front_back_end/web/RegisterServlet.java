/*
package com.wahid.front_back_end.web;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

import com.wahid.front_back_end.dao.UserDao;
import com.wahid.front_back_end.model.User;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // ======== GET PARAMETERS ========
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");

        // ======== BASIC VALIDATION ========
        if (name == null || email == null || password == null ||
                name.isEmpty() || email.isEmpty() || password.isEmpty()) {

            resp.getWriter().println("All fields are required!");
            return;
        }

        if (!password.equals(confirmPassword)) {
            resp.getWriter().println("Passwords do not match!");
            return;
        }

        // ======== DAO OBJECT ========
        UserDao dao = new UserDao();

        // ======== CHECK DUPLICATE EMAIL ========
        if (dao.emailExists(email)) {
            resp.getWriter().println("Email already registered!");
            return;
        }

        // ======== CREATE USER OBJECT ========
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);

        // ======== SAVE USER ========
        boolean isSaved = dao.saveUser(user);

        // ======== RESPONSE ========
        if (isSaved) {
            resp.sendRedirect("index.html"); // go back to login
        } else {
            resp.getWriter().println("Registration failed!");
        }
    }
}
*/
package com.wahid.front_back_end.web;

import jakarta.servlet.*;
        import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
        import java.io.IOException;
import com.wahid.front_back_end.dao.UserDao;
import com.wahid.front_back_end.model.User;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private UserDao dao;

    @Override
    public void init() {
        dao = new UserDao();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");

        if (name == null || email == null || password == null || name.isEmpty()) {
            resp.getWriter().println("All fields are required!");
            return;
        }

        if (!password.equals(confirmPassword)) {
            resp.getWriter().println("Passwords do not match!");
            return;
        }

        if (dao.emailExists(email)) {
            resp.getWriter().println("Email already registered!");
            return;
        }

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);

        boolean isSaved = dao.saveUser(user);

        if (isSaved) {
            resp.sendRedirect("index.html");
        } else {
            // If this shows up, check your IntelliJ CONSOLE for the Red Text (Stacktrace)
            resp.getWriter().println("Registration failed! Check server logs for details.");
        }
    }
}