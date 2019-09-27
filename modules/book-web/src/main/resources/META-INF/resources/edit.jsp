<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="init.jsp"%>

<%
    String bookId = request.getParameter("bookId");
    String title = request.getParameter("title");
    String author = request.getParameter("author");
    String price = request.getParameter("price");
%>

<portlet:actionURL var="updateBook" name="updateBook">
</portlet:actionURL>

<form action="<%= updateBook %>" method="post">
    <input name="<portlet:namespace/>bookId" value="<%= bookId %>" readonly/>
    <input name="<portlet:namespace/>title" type="text" value="<%= title %>"/>
    <input name="<portlet:namespace/>author" type="text" value="<%= author %>"/>
    <input name="<portlet:namespace/>price" type="number" value="<%= price %>"/>
    <input type="submit" value="提交">
</form>

