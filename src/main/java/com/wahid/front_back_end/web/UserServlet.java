package com.wahid.front_back_end.web;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

import com.wahid.front_back_end.dao.UserDao;
import com.wahid.front_back_end.model.User;

@WebServlet({"/users", "/delete", "/edit", "/update", "/insert", "/new"})
public class UserServlet extends HttpServlet {

    private UserDao dao;

    public void init() {
        dao = new UserDao();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String action = req.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showForm(resp);
                    break;

                case "/insert":
                    insertUser(req, resp);
                    break;

                case "/delete":
                    deleteUser(req, resp);
                    break;

                case "/edit":
                    editUser(req, resp);
                    break;

                case "/update":
                    updateUser(req, resp);
                    break;

                default:
                    listUsers(resp);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().println("Error occurred: " + e.getMessage());
        }
    }

    // ================= LIST =================
    private void listUsers(HttpServletResponse resp) throws IOException {
        try {
            List<User> users = dao.getAllUsers();

            resp.setContentType("text/html");

            resp.getWriter().println("""
            <html>
            <head>
                <title>All Users</title>
                <style>
                    body { font-family: Arial; padding: 20px; }
                    table { border-collapse: collapse; width: 80%; }
                    th, td { border: 1px solid #ddd; padding: 10px; text-align: center; }
                    th { background-color: #2c3e50; color: white; }
                    a { margin: 0 5px; text-decoration: none; }
                    .btn { padding: 5px 10px; border-radius: 5px; }
                    .delete { background: red; color: white; }
                    .edit { background: green; color: white; }
                    .add { background: blue; color: white; padding: 10px; display: inline-block; margin-top: 10px; }
                </style>
            </head>
            <body>
            <h2>All Users</h2>

            <table>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Actions</th>
                </tr>
        """);

            for (User u : users) {
                resp.getWriter().println(
                        "<tr>" +
                                "<td>" + u.getId() + "</td>" +
                                "<td>" + u.getName() + "</td>" +
                                "<td>" + u.getEmail() + "</td>" +
                                "<td>" +
                                "<a class='btn edit' href='edit?id=" + u.getId() + "'>Edit</a>" +
                                "<a class='btn delete' href='delete?id=" + u.getId() + "'>Delete</a>" +
                                "</td>" +
                                "</tr>"
                );
            }

            resp.getWriter().println("""
            </table>

            <a class='add' href='new'>+ Add New User</a>

            </body>
            </html>
        """);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // ================= NEW =================
    private void showForm(HttpServletResponse resp) throws IOException {
        try {
            resp.setContentType("text/html");

            resp.getWriter().println("""
                <html><body>
                <h2>Add User</h2>
                <form action='insert' method='post'>
                    Name: <input name='name'><br><br>
                    Email: <input name='email'><br><br>
                    Password: <input name='password'><br><br>
                    <button type='submit'>Save</button>
                </form>
                </body></html>
            """);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ================= INSERT =================
    private void insertUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            User user = new User();

            user.setName(req.getParameter("name"));
            user.setEmail(req.getParameter("email"));
            user.setPassword(req.getParameter("password"));

            dao.saveUser(user);

            resp.sendRedirect("users");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ================= DELETE =================
    private void deleteUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));

            dao.deleteUser(id);

            resp.sendRedirect("users");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ================= EDIT =================
    private void editUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));

            User user = dao.getUserById(id);

            if (user == null) {
                resp.getWriter().println("User not found");
                return;
            }

            resp.setContentType("text/html");

            resp.getWriter().println(
                    "<html><body>" +
                            "<h2>Edit User</h2>" +
                            "<form action='update' method='post'>" +
                            "<input type='hidden' name='id' value='" + user.getId() + "'>" +

                            "Name: <input name='name' value='" + user.getName() + "'><br><br>" +
                            "Email: <input name='email' value='" + user.getEmail() + "'><br><br>" +
                            "Password: <input name='password' value='" + user.getPassword() + "'><br><br>" +

                            "<button type='submit'>Update</button>" +
                            "</form>" +
                            "</body></html>"
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ================= UPDATE =================
    private void updateUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            User user = new User();

            user.setId(Integer.parseInt(req.getParameter("id")));
            user.setName(req.getParameter("name"));
            user.setEmail(req.getParameter("email"));
            user.setPassword(req.getParameter("password"));

            dao.updateUser(user);

            resp.sendRedirect("users");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}