package ru.bulat.servlets;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.bulat.data.DatabaseConnection;
import ru.bulat.session.Namenator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getServletContext().getRequestDispatcher("/jsp/registration.jsp").forward(request,response);
        Namenator.getName(request);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException {
        String nickname = request.getParameter("nickname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String rePassword = request.getParameter("rePassword");
        Pattern patternEmail = Pattern.compile("^[_A-Za-z0-9-+]+(\\.[_A-Za-z0-9-]+)*@" +
                "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcherEmail = patternEmail.matcher(email);
        if (!matcherEmail.matches() || !password.equals(rePassword) || !(password.length() > 6) || !(password.length() < 31)) {
            response.sendRedirect(request.getContextPath() + "/registration");
        }else{
            PasswordEncoder encoder = new BCryptPasswordEncoder();
            String hashPassword = encoder.encode(password);
            int id = DatabaseConnection.writeToDatabaseNewUser(nickname, email, hashPassword);
            HttpSession session1 = request.getSession();
            session1.setAttribute("id", id);
            HttpSession session2 = request.getSession();
            session2.setAttribute("nickname", nickname);
            response.sendRedirect(request.getContextPath() + "/chat");
        }

    }
}
