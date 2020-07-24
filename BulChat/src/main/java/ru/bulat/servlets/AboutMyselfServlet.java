package ru.bulat.servlets;

import ru.bulat.data.DatabaseConnection;
import ru.bulat.model.Group;
import ru.bulat.model.Information;
import ru.bulat.model.User_Group;
import ru.bulat.utils.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/settings/aboutMyself")
public class AboutMyselfServlet extends HttpServlet {
    private static Map<String, String> descriptionOfAllErrors = new HashMap<>();
    private static String error = "";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getServletContext().getRequestDispatcher("/jsp/aboutMyself.jsp").forward(request, response);
        Session.createSession(request, "help", error);
        Session.getName(request);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String[] groups = request.getParameterValues("groups");
        String newGroup = request.getParameter("newGroup");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String patronymic = request.getParameter("patronymic");
        String phone = request.getParameter("phone");
        String dateOfBirth = request.getParameter("date of birth");
        String gender = request.getParameter("gender");
        String country = request.getParameter("country");
        String aboutMyself = request.getParameter("about myself");

        error += "Conditions not met: ";

        fillingOutADescriptionOfAllErrors();

        phoneChecking(phone);
        dateOfBirthChecking(dateOfBirth);
        aboutMyselfChecking(aboutMyself);

        workWithTheDatabase(groups, newGroup, name, surname, patronymic, phone, dateOfBirth, gender, country, aboutMyself, request, response);
    }

    private static void fillingOutADescriptionOfAllErrors() {
        descriptionOfAllErrors.put("Incorrectly phone", "Phone entered incorrectly, ");
        descriptionOfAllErrors.put("Incorrectly date", "Date entered is incorrect, ");
        descriptionOfAllErrors.put("Incorrectly aboutMyself", "Too much is written in aboutMyself, ");
    }


    private static void phoneChecking(String phone) {
        Pattern patternPhone = Pattern.compile("\\+\\d(-\\d{3}){2}-\\d{4}");
        Matcher matcherPhone = patternPhone.matcher(phone);
        if (!matcherPhone.matches()) error += descriptionOfAllErrors.get("Incorrectly phone");
    }

    private static void dateOfBirthChecking(String dateOfBirth) {
        Pattern patternDate = Pattern.compile("[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01])");
        Matcher matcherDate = patternDate.matcher(dateOfBirth);
        if (!matcherDate.matches()) error += descriptionOfAllErrors.get("Incorrectly date");
    }

    private static void aboutMyselfChecking(String aboutMyself) {
        if (aboutMyself.length() > 1000) error += descriptionOfAllErrors.get("Incorrectly aboutMyself");
    }

    private static void workWithTheDatabase(String[] groups, String newGroup, String name, String surname, String patronymic, String phone, String dateOfBirth,
                                            String gender, String country, String aboutMyself, HttpServletRequest request,
                                            HttpServletResponse response) throws IOException {
        if (error.equals("Conditions not met: ")) {
            Information information = DatabaseConnection.save(Information.builder()
                    .name(name)
                    .surname(surname)
                    .patronymic(patronymic)
                    .phone(phone)
                    .dateOfBirth(dateOfBirth).gender(gender).country(country).aboutMySelf(aboutMyself).build());
            List<String> allGroups = new ArrayList<>(Arrays.asList(groups));
            if (!newGroup.equals("")) {
                allGroups.add(newGroup);
                DatabaseConnection.save(Group.builder()
                        .name(newGroup)
                        .build());
            }
            Long needId = (Long) Session.getSession(request, "id");
            for (String group : allGroups) {
                Optional<Group> groupOptional = DatabaseConnection.findByName(group);
                groupOptional.ifPresent(group1 -> DatabaseConnection.save(User_Group.builder()
                        .group_id(group1.getId())
                        .user_id(needId)
                        .build()));
            }
            DatabaseConnection.updateInformation(needId, information.getId());
            response.sendRedirect(request.getContextPath() + "/settings/aboutMyself/success");
        } else {
            Session.createSession(request, "help", error);
            response.sendRedirect(request.getContextPath() + "/settings/aboutMyself");
        }
    }

}
