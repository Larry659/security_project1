package com.lanre.security_project1.configuration;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.logging.Logger;

public class AuthenticationLoggingFilter implements Filter {

    private final Logger logger = Logger.getLogger(AuthenticationLoggingFilter.class.getName());


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        ServletRequest request = (ServletRequest) servletRequest;
        ServletResponse response = (ServletResponse) servletResponse;
        var httpRequest = (HttpServletRequest) request;
        var requestId = httpRequest.getHeader("Request-Id");
        logger.info("Successfully authenticated request with id " + requestId);
                filterChain.doFilter(request, response);
    }
}
