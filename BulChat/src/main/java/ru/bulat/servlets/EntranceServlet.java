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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/entrance")
public class EntranceServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getServletContext().getRequestDispatcher("/jsp/entrance.jsp").forward(request,response);
        Session.getName(request);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Optional<User> userOptional = DatabaseConnection.findByEmail(email);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (passwordEncoder.matches(password, user.getPassword())){
                Session.createSession(request, "nickname", user.getNickname());
                Session.createSession(request, "email", user.getEmail());
                HttpSession session2 = request.getSession();
                session2.setAttribute("id", user.getId());
                response.sendRedirect(request.getContextPath() + "/chat");
            }else{
                response.sendRedirect(request.getContextPath() + "/entrance");
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/entrance");
        }
    }
}
