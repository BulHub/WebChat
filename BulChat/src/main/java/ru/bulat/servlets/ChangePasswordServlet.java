package ru.bulat.servlets;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.bulat.data.DatabaseConnection;
import ru.bulat.model.User;
import ru.bulat.utils.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/settings/changePassword")
public class ChangePasswordServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getServletContext().getRequestDispatcher("/jsp/changePassword.jsp").forward(request,response);
        Session.createSession(request, "change", "");
        Session.getName(request);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException {
        String change = "";
        String email = request.getParameter("email");
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        Optional<User> userOptional = DatabaseConnection.findByEmail(email);
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        if (userOptional.isPresent()){
            if (encoder.matches(oldPassword, userOptional.get().getPassword())){
                DatabaseConnection.updatePassword(email, encoder.encode(newPassword));
                change +="Password changed successfully!";
                Session.createSession(request,"change", change);
            }else {
                change ="Password could not be changed!";
                Session.createSession(request,"change", change);
            }
        }else{
            change ="Password could not be changed!";
            Session.createSession(request,"change", change);
        }
        response.sendRedirect(request.getContextPath() + "/settings/changePassword");
    }
}
