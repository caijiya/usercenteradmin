package com.zy.usercenteradmin.filter;

/**
 * @Author: ZhaoYang
 * @Date: 2022/1/22
 */

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@WebFilter(urlPatterns = "/*")
@Order(-99999)
public class CorsFilter extends HttpFilter {
    private static final long serialVersionUID = 2386571986045107652L;
    private static final String OPTIONS_METHOD = "OPTIONS";

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {

        String origin = req.getHeader(HttpHeaders.ORIGIN);

        if (!StringUtils.isEmpty(origin)) {

            // 允许客户端的域
            res.addHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, origin);

            // 允许客户端提交的Header
            String requestHeaders = req.getHeader(HttpHeaders.ACCESS_CONTROL_REQUEST_HEADERS);
            if (!StringUtils.isEmpty(requestHeaders)) {
                res.addHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, requestHeaders);
            }

            // 允许客户端访问的Header
            res.addHeader(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, "*");

            // 允许客户端携带凭证信息
            res.addHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS, "true");

            // 允许客户端请求方法
            res.addHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, "GET, POST, PUT, OPTIONS, DELETE");

            if (OPTIONS_METHOD.equalsIgnoreCase(req.getMethod())) {
                res.setStatus(HttpServletResponse.SC_NO_CONTENT);
                res.setContentType(MediaType.TEXT_HTML_VALUE);
                res.setCharacterEncoding("utf-8");
                res.setContentLength(0);
                res.addHeader(HttpHeaders.ACCESS_CONTROL_MAX_AGE, "1800");
                return;
            }
        }

        super.doFilter(req, res, chain);
    }
}


