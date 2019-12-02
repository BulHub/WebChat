package ru.bulat.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(
        urlPatterns = {"/settings/*","/chat", "/feedback", "/developers", "/profile", "/"}
)
public class MainFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter init!");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("id") == null){
            response.sendRedirect(request.getContextPath() + "/entrance");
        }else{
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        System.out.println("Filter destroy!");
    }
}
