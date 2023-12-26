<%@ page import="java.util.Enumeration" %>
<%--
  Created by IntelliJ IDEA.
  User: 정인호
  Date: 2023-12-26
  Time: 오전 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    System.out.println("<전체 request.getAttribute 출력>");
    Enumeration<String> requestAttributeNames = request.getAttributeNames();
    while(requestAttributeNames.hasMoreElements()){
        String requestAttributeName = (String) requestAttributeNames.nextElement();
        if(!requestAttributeName.startsWith("jakarta.servlet.")&&!requestAttributeName.startsWith("org.springframework."))
        System.out.println("requestAttributeName:"+requestAttributeName+" , "+"toString = "+ request.getAttribute(requestAttributeName).toString());

    }
    System.out.println("<전체 session.getAttribute 출력>");
    Enumeration<String> sessionAttributeNames = session.getAttributeNames();
    while(sessionAttributeNames.hasMoreElements()){
        String sessionAttributeName = (String)sessionAttributeNames.nextElement();
        System.out.println("sessionAttributeName:"+ sessionAttributeName +"toString = "+ session.getAttribute(sessionAttributeName).toString());
    }
%>