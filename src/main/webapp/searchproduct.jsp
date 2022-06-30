<%@page import="dao.ProductDAO"%>
<%@page import="dto.ProductDTO"%>
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
<h1>제품 정보 출력</h1>
<%
request.setCharacterEncoding("utf-8");
    String name_1 = request.getParameter("name");
    ProductDTO productVO = new ProductDTO();
    productVO.setName(name_1);
    ProductDAO dao = new ProductDAO();
    List productList = dao.slistproduct(productVO);
%>
<table border=1 style="width:800px;align:center">
    <tr align=center bgcolor="#FFFF66">
        <th>아이디</th>
        <th>제품명</th>
        <th>스펙</th>
        <th>standard cost</th>
        <th>list price</th>
    </tr>
    <%
    for(int i=0; i<productList.size(); i++){
            	ProductDTO vo = (ProductDTO) productList.get(i);
                String id=vo.getId();
                String name = vo.getName();
                String des = vo.getDes();
                String cost = vo.getCost();
                String price = vo.getPrice();
    %>
    
    <tr align="center">
        <td><%= id %></td>
        <td><%= name %></td>
        <td><%= des %></td>
        <td><%= cost %></td>
        <td><%= price %></td>
    </tr>
    <%    
        }
    %>
</table>
 
</body>
</html>
