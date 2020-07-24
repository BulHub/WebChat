package ru.bulat.filters;

import ru.bulat.data.DatabaseConnection;
import ru.bulat.model.User;
import ru.bulat.utils.Session;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@WebFilter("/settings/aboutMyself")
public class FilterAboutFillingInformation implements Filter {

    @Override
    public void init(FilterConfig filterConfig){
        System.out.println("Filter init!");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);
        Long id = (Long) session.getAttribute("id");
        if (id != null) {
            String email = (String) Session.getSession(request, "email");
            Optional<User> user = DatabaseConnection.findByEmail(email);
            if (user.get().getInformation_id() != 0) {
                response.sendRedirect(request.getContextPath() + "/settings/aboutMyself/success");
            }
            else {
                filterChain.doFilter(request, response);
            }
        }
    }

    @Override
    public void destroy() {
        System.out.println("Filter destroy!");
    }
}
