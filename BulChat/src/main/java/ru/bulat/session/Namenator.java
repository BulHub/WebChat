package ru.bulat.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Namenator {

    public static void getName(HttpServletRequest request){
        HttpSession session1 = request.getSession();
        String nickname = (String) session1.getAttribute("nickname");
        HttpSession session2 = request.getSession();
        session2.setAttribute("nickname", nickname);
    }
}
