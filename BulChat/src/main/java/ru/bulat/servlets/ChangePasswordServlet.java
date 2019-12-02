package ru.bulat.servlets;

import ru.bulat.data.DatabaseConnection;
import ru.bulat.session.Namenator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/settings/changePassword")
public class ChangePasswordServlet extends HttpServlet {
    private static String change = "";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getServletContext().getRequestDispatcher("/jsp/changePassword.jsp").forward(request,response);
        HttpSession session = request.getSession();
        session.setAttribute("change", "");
        Namenator.getName(request);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException {
        String email = request.getParameter("email");
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        int id = DatabaseConnection.userVerification(email,oldPassword);
        HttpSession session = request.getSession();
        if (id != -1){
            DatabaseConnection.changePassword(email, newPassword, oldPassword);
            change="Password changed successfully!";
            session.setAttribute("change", change);
        }else{
            change+="Password could not be changed!";
            session.setAttribute("change", change);
        }
        response.sendRedirect(request.getContextPath() + "/settings/changePassword");
    }
}
