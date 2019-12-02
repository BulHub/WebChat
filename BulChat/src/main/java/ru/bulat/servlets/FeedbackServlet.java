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

@WebServlet("/feedback")
public class FeedbackServlet extends HttpServlet {
    private static String help = "";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getServletContext().getRequestDispatcher("/jsp/feedback.jsp").forward(request,response);
        HttpSession session = request.getSession();
        session.setAttribute("help", help);
        Namenator.getName(request);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String message = request.getParameter("message");
        int idF = DatabaseConnection.recordNewFeedback(name, email, message);
        HttpSession session1 = request.getSession();
        int idU = (Integer) session1.getAttribute("id");
        DatabaseConnection.recordingFeedbackWithUser(idU, idF);
        HttpSession session2 = request.getSession();
        help+="Your form has been submitted. Thanks for the feedback)";
        session2.setAttribute("help", help);
        response.sendRedirect(request.getContextPath() + "/feedback");
    }
}
