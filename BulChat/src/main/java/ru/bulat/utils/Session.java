package ru.bulat.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Session {

    public static void getName(HttpServletRequest request){
        HttpSession session1 = request.getSession();
        String nickname = (String) session1.getAttribute("nickname");
        HttpSession session2 = request.getSession();
        session2.setAttribute("nickname", nickname);
    }

    public static void createSession(HttpServletRequest request, String key, String value){
        HttpSession session2 = request.getSession();
        session2.setAttribute(key, value);
    }

    public static Object getSession(HttpServletRequest request, String key){
        HttpSession session1 = request.getSession(false);
        return session1.getAttribute(key);
    }
}
