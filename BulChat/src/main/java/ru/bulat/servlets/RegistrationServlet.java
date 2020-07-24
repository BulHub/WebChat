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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getServletContext().getRequestDispatcher("/jsp/registration.jsp").forward(request,response);
        Session.getName(request);
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
        Optional<User> userOptional = DatabaseConnection.findByEmail(email);
        if (!matcherEmail.matches() || !password.equals(rePassword) || !(password.length() > 6) || !(password.length() < 31
        || userOptional.isPresent())) {
            response.sendRedirect(request.getContextPath() + "/registration");
        }else{
            PasswordEncoder encoder = new BCryptPasswordEncoder();
            String hashPassword = encoder.encode(password);
            User user = DatabaseConnection.save(User.builder()
                    .nickname(nickname)
                    .email(email)
                    .password(hashPassword)
                    .build());
            HttpSession session1 = request.getSession();
            session1.setAttribute("id", user.getId());
            Session.createSession(request, "nickname", nickname);
            Session.createSession(request, "email", email);
            response.sendRedirect(request.getContextPath() + "/chat");
        }

    }
}
