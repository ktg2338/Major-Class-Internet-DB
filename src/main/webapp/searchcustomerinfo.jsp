<%@page import="dto.CustomerInfoDTO"%>
<%@page import="dao.CustomerDAO"%>
<%@page import="dto.CustomerDTO"%>
<%@page import="dao.CustomerInfoDAO"%>


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
    int Id = Integer.parseInt(request.getParameter("id"));
    System.out.println(Id);
    CustomerInfoDTO customerInfoVo = new CustomerInfoDTO();
    customerInfoVo.setCustomer_id(Id);
    dao.CustomerInfoDAO dao = new dao.CustomerInfoDAO();
    List customerlist = dao.slistcustomer(customerInfoVo);
%>
<table border=1 style="width:800px;align:center">
    <tr align=center bgcolor="#FFFF66">
        <th>고객ID</th>
        <th>주문번호</th>
        <th>상태</th>
        <th>상품이름</th>
        <th>수량</th>
        <th>Unit Price</th>
        <th>Standard Cost</th>
    </tr>
    <%
    for(int i=0; i<customerlist.size(); i++){
            	CustomerInfoDTO vo = (CustomerInfoDTO) customerlist.get(i);
            	int customer_id=vo.getCustomer_id();
                String order_id=vo.getOrder_id();
                String status = vo.getStatus();
                String product_name = vo.getProduct_name();
                String quantity = vo.getQuantity();
                String unit_price = vo.getUnit_price();
                String standard_cost = vo.getStandard_cost();
    %>
    
    <tr align="center">
        <td><%= customer_id %></td>
        <td><%= order_id %></td>
        <td><%= status %></td>
        <td><%= product_name %></td>
        <td><%= quantity %></td>
        <td><%= unit_price %></td>
        <td><%= standard_cost %></td>
    </tr>
    <%    
        }
    %>
</table>
 
</body>
</html>
