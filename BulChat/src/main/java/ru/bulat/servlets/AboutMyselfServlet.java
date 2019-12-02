package ru.bulat.servlets;

import ru.bulat.data.DatabaseConnection;
import ru.bulat.session.Namenator;

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
        request.getServletContext().getRequestDispatcher("/jsp/aboutMyself.jsp").forward(request,response);
        HttpSession session = request.getSession();
        session.setAttribute("help", error);
        Namenator.getName(request);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException {
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

        error+="Conditions not met: ";

        fillingOutADescriptionOfAllErrors();

        phoneChecking(phone);
        dateOfBirthChecking(dateOfBirth);
        aboutMyselfChecking(aboutMyself);

        workWithTheDatabase(groups, newGroup, name, surname, patronymic, phone, dateOfBirth, gender, country, aboutMyself, request, response);
    }

    private static void fillingOutADescriptionOfAllErrors(){
        descriptionOfAllErrors.put("Incorrectly phone", "Phone entered incorrectly, ");
        descriptionOfAllErrors.put("Incorrectly date", "Date entered is incorrect, ");
        descriptionOfAllErrors.put("Incorrectly aboutMyself", "Too much is written in aboutMyself, ");
    }


    private static void phoneChecking(String phone){
        Pattern patternPhone = Pattern.compile("\\+\\d(-\\d{3}){2}-\\d{4}");
        Matcher matcherPhone = patternPhone.matcher(phone);
        if (!matcherPhone.matches()) error +=descriptionOfAllErrors.get("Incorrectly phone");
    }

    private static void dateOfBirthChecking(String dateOfBirth){
        Pattern patternDate = Pattern.compile("[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01])");
        Matcher matcherDate = patternDate.matcher(dateOfBirth);
        if (!matcherDate.matches()) error +=descriptionOfAllErrors.get("Incorrectly date");
    }

    private static void aboutMyselfChecking(String aboutMyself){
        if (aboutMyself.length() > 1000) error +=descriptionOfAllErrors.get("Incorrectly aboutMyself");
    }

    private static void workWithTheDatabase(String[] groups, String newGroup, String name, String surname, String patronymic, String phone, String dateOfBirth,
                                            String gender, String country, String aboutMyself, HttpServletRequest request,
                                            HttpServletResponse response) throws IOException {
        if (error.equals("Conditions not met: ")){
            int id = DatabaseConnection.recordingAdditionalUserData(name, surname, patronymic, phone, dateOfBirth, gender, country, aboutMyself);
            if (id == -1) new IllegalStateException();
            List<String> allGroups = new ArrayList<>(Arrays.asList(groups));
            if (!newGroup.equals("")){
                allGroups.add(newGroup);
                DatabaseConnection.writeNewGroup(newGroup);
            }
            for (String group : allGroups) DatabaseConnection.recordGroupsForUsers(id, group);
            HttpSession session1 = request.getSession(false);
            Integer needId = (Integer) session1.getAttribute("id");
            DatabaseConnection.formFillingRecord(needId);
            DatabaseConnection.recordInfoForUsers(needId, id);
            response.sendRedirect(request.getContextPath() + "/settings/aboutMyself/success");
        }
        else{
            HttpSession session = request.getSession();
            session.setAttribute("help", error);
            response.sendRedirect(request.getContextPath() + "/settings/aboutMyself");
        }
    }

}
