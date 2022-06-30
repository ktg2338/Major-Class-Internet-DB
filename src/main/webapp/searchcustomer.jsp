
<%@page import="dao.CustomerDAO"%>
<%@page import="dto.CustomerDTO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*"
    import="sec04.ex01.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>회원 정보 조회 페이지</title>
</head>
<body>
<h1>고객 정보 출력</h1>



<%
request.setCharacterEncoding("utf-8");
    String name_1 = request.getParameter("name");
    CustomerDTO customerVO = new CustomerDTO();
    customerVO.setName(name_1);
    CustomerDAO dao = new CustomerDAO();
    List customerlist = dao.slistcustomer(customerVO);
%>
<table border=1 style="width:800px;align:center">
    <tr align=center bgcolor="#FFFF66">
        <th>아이디</th>
        <th>이름</th>
        <th>주소</th>
        <th>사이트</th>
        <th>신용한도</th>
    </tr>
    <%
    for(int i=0; i<customerlist.size(); i++){
            	CustomerDTO vo = (CustomerDTO) customerlist.get(i);
                String id=vo.getId();
                String name = vo.getName();
                String address = vo.getAddress();
                String website = vo.getWebsite();
                String creditlimit = vo.getCreditlimit();
    %>
    
    <tr align="center">
        <td>
        <%= id %>
        <form name="myForm" action="/shop/searchcustomerinfo.jsp" method="POST">
		<input type="hidden" name="id" value="<%= id %>" />
		<button type="submit" name="id" value="<%= id %>" class="btn-link">Go</button>
		</form>
        </td>
        <td><%= name %></td>
        <td><%= address %></td>
        <td><%= website %></td>
        <td><%= creditlimit %></td>
    </tr>
    <%    
        }
    %>
</table>
 
</body>
</html>
