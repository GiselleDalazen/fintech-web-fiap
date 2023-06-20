package br.com.fintech.filter;

import br.com.fintech.model.Usuario;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    public static Usuario usuario = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    public LoginFilter() {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filter)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession();
        String url = httpRequest.getRequestURI();
        String loginURI = ((HttpServletRequest) request).getContextPath() + "/login";
        String registerURI = ((HttpServletRequest) request).getContextPath() + "/cadastro";

        Usuario user = (Usuario) session.getAttribute("usuario");
        if(user == null) this.usuario = user;

        boolean logado = session != null &&  user != null;
        boolean loginRequest = url.equals(loginURI);
        boolean registerRequest = url.equals(registerURI);

        if (logado || loginRequest || registerRequest) {
            filter.doFilter(request, response);
        } else {
            ((HttpServletResponse) response).sendRedirect(loginURI);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
