<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="init.jsp"%>

<portlet:actionURL var="addBook" name="addBook">
</portlet:actionURL>

<form action="<%= addBook %>" method="post">
    <input name="<portlet:namespace/>title" type="text"/>
    <input name="<portlet:namespace/>author" type="text"/>
    <input name="<portlet:namespace/>price" type="number"/>
    <input type="submit" value="提交">
</form>