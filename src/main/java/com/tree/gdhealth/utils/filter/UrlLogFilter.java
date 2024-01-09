package com.tree.gdhealth.utils.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * <p>접근URL의 로깅을 위한 필터, 정적리소스는 제외시킴</p>
 * @author 정인호
 */
@Slf4j
@Component
public class UrlLogFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        String[] exceptUrls = {"/img/","/js/","/css/","/fonts/","/style.css"};
        for(String url : exceptUrls){
            if (httpRequest.getServletPath().contains(url)){
                chain.doFilter(request, response);
                return;
            }
        }
        log.debug("접근된 URL = {}",httpRequest.getServletPath());
        chain.doFilter(request, response);
    }
}
