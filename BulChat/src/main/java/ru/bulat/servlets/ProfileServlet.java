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
import java.util.List;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Namenator.getName(request);
        HttpSession session1 = request.getSession();
        Integer idU = (Integer) session1.getAttribute("id");
        int idI = DatabaseConnection.receivingAdditionalWithId(idU);
        if (idI != -1) {
            List name = DatabaseConnection.receivingAdditionalInformationAboutTheUser(idI);
            if (name != null) {
                request.setAttribute("name", name.get(0));
                request.setAttribute("surname", name.get(1));
                request.setAttribute("patronymic", name.get(2));
                request.setAttribute("phone", name.get(3));
                request.setAttribute("dateOfBirth", name.get(4));
                request.setAttribute("gender", name.get(5));
                request.setAttribute("country", name.get(6));
            }
        }else{
            HttpSession session2 = request.getSession();
            session2.setAttribute("look", "You have not completed the form at this time. You can fill in the paragraph \"AboutMyself\"");
        }
        request.getServletContext().getRequestDispatcher("/jsp/profile.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
