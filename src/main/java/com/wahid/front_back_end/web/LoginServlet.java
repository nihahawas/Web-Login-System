package com.wahid.front_back_end.web;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

import com.wahid.front_back_end.dao.UserDao;
import com.wahid.front_back_end.model.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // ======== GET DATA ========
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        // ======== VALIDATION ========
        if (email == null || password == null ||
                email.isEmpty() || password.isEmpty()) {

            resp.getWriter().println("Please enter all fields!");
            return;
        }

        // ======== DAO CALL ========
        UserDao dao = new UserDao();
        User user = dao.getUser(email, password);

        // ======== LOGIN LOGIC ========
        if (user != null) {

            // 🔥 CREATE SESSION
            HttpSession session = req.getSession();
            session.setAttribute("user", user);

            // 🔥 REDIRECT TO DASHBOARD
            resp.sendRedirect("dashboard.html");

        } else {
            resp.getWriter().println("Invalid email or password!");
        }
    }
}