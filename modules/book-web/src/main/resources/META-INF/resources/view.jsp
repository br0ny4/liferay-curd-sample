<%@ page import="com.dz100.book.model.Book" %>
<%@ page import="java.util.List" %>
<%@ include file="/init.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<%
    int currentPage = (int) request.getAttribute("currentPage");
    int pageCount = (int) request.getAttribute("pageCount");
    List<Book> books = (List<Book>) request.getAttribute("books");
%>

<portlet:renderURL var="addBook">
    <portlet:param name="mvcPath" value="/add.jsp"/>
</portlet:renderURL>

<portlet:renderURL var="home">
    <portlet:param name="page_number" value="1"/>
</portlet:renderURL>

<portlet:renderURL var="next">
    <portlet:param name="page_number" value="<%= String.valueOf(currentPage + 1)%>"/>
</portlet:renderURL>

<portlet:renderURL var="prev">
    <portlet:param name="page_number" value="<%= String.valueOf(currentPage - 1)%>"/>
</portlet:renderURL>

<portlet:renderURL var="end">
    <portlet:param name="page_number" value="<%= String.valueOf(pageCount) %>"/>
</portlet:renderURL>


<button onclick="window.location='<%= addBook %>'">添加</button>

<table>
    <tr>
        <th>书号</th>
        <th>书名</th>
        <th>作者</th>
        <th>价格</th>
        <th>操作</th>
    </tr>
    <%for (Book book : books) {%>
    <tr>
        <td><%= book.getBookId()%></td>
        <td><%= book.getTitle()%></td>
        <td><%= book.getAuthor()%></td>
        <td><%= book.getPrice()%></td>
        <td>
            <portlet:renderURL var="updateBook">
                <portlet:param name="mvcPath" value="/edit.jsp"/>
                <portlet:param name="bookId" value="<%= String.valueOf(book.getBookId()) %>"/>
                <portlet:param name="title" value="<%= book.getAuthor() %>"/>
                <portlet:param name="author" value="<%= book.getAuthor()%>"/>
                <portlet:param name="price" value="<%= String.valueOf(book.getPrice()) %>"/>
            </portlet:renderURL>
            <button onclick="window.location='<%= updateBook %>'">更新</button>

            <portlet:actionURL var="deleteBook" name="deleteBook">
                <portlet:param name="bookId" value="<%= String.valueOf(book.getBookId())%>"/>
            </portlet:actionURL>

            <button onclick="window.location='<%= deleteBook %>'">删除</button>
        </td>
    </tr>
    <%}%>
</table>

<button onclick="window.location='<%= home %>'" <c:if test="<%= currentPage == 1%>"><c:out value="disabled='disabled'"/> </c:if>>
首页
    </button>

<button onclick="window.location='<%= prev %>'" <c:if test="<%= currentPage == 1%>"><c:out value="disabled='disabled'"/> </c:if>>
          上页
</button>

第<%= currentPage %>页

<button onclick="window.location='<%= next %>'" <c:if test="<%= currentPage == pageCount%>"><c:out value="disabled='disabled'"/> </c:if>>
        下页
</button>

<button onclick="window.location='<%= end %>'" <c:if test="<%= currentPage == pageCount%>"><c:out value="disabled='disabled'"/> </c:if>>
        末页
</button>