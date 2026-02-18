package com.lanre.security_project1.filters;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class RequestValidationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {


        ServletRequest request = (ServletRequest) servletRequest;
        HttpServletRequest httpRequest = (HttpServletRequest) request;

        ServletResponse response = (ServletResponse) servletResponse;
        var httpResponse = (HttpServletResponse) response;
        String requestId = httpRequest.getHeader("Request-Id");

        if (requestId == null || requestId.isBlank()) {
            httpResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        filterChain.doFilter(request, response);
    }
}
