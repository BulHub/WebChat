package ru.bulat.servlets;

import ru.bulat.data.DatabaseConnection;
import ru.bulat.model.Information;
import ru.bulat.model.User;
import ru.bulat.utils.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Session.getName(request);
        String email = (String) Session.getSession(request, "email");
        Optional<User> userOptional = DatabaseConnection.findByEmail(email);
        if (userOptional.get().getInformation_id() != 0) {
            Optional<Information> informationOptional = DatabaseConnection.findById(userOptional.get().getInformation_id());
            if (informationOptional.isPresent()){
                Information information = informationOptional.get();
                request.setAttribute("id", information.getId());
                request.setAttribute("name", information.getName());
                request.setAttribute("surname", information.getSurname());
                request.setAttribute("patronymic", information.getPatronymic());
                request.setAttribute("phone", information.getPhone());
                request.setAttribute("dateOfBirth", information.getDateOfBirth());
                request.setAttribute("gender", information.getGender());
                request.setAttribute("country", information.getCountry());
            }
        }else{
            Session.createSession(request, "look", "You have not completed the form at this time. You can fill in the paragraph \"AboutMyself\"");
        }
        request.getServletContext().getRequestDispatcher("/jsp/profile.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
