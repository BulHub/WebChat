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

@WebServlet("/entrance")
public class EntranceServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getServletContext().getRequestDispatcher("/jsp/entrance.jsp").forward(request,response);
        Namenator.getName(request);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        int id = DatabaseConnection.userVerification(email, password);
        if (id != -1) {
            String nickname = DatabaseConnection.gettingANickname(id);
            HttpSession session1 = request.getSession();
            session1.setAttribute("nickname", nickname);
            HttpSession session2 = request.getSession();
            session2.setAttribute("id", id);
            response.sendRedirect(request.getContextPath() + "/chat");
        } else {
            response.sendRedirect(request.getContextPath() + "/entrance");
        }
    }
}
