package ru.bulat.servlets;

import ru.bulat.data.DatabaseConnection;
import ru.bulat.model.Feedback;
import ru.bulat.model.User_Feedback;
import ru.bulat.utils.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/feedback")
public class FeedbackServlet extends HttpServlet {
    private static String help = "";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getServletContext().getRequestDispatcher("/jsp/feedback.jsp").forward(request, response);
        Session.createSession(request, "help", help);
        Session.getName(request);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        help="";
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String message = request.getParameter("message");
        Feedback feedback = DatabaseConnection.save(Feedback.builder()
                .name(name)
                .email(email)
                .message(message)
                .build());
        HttpSession session1 = request.getSession();
        long idU = (Long) session1.getAttribute("id");
        DatabaseConnection.save(User_Feedback.builder()
                .user_id(idU)
                .feedback_id(feedback.getId())
                .build());
        help += "Your form has been submitted. Thanks for the feedback)";
        Session.createSession(request, "help", help);
        response.sendRedirect(request.getContextPath() + "/feedback");
    }
}
