<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<%
		Cookie[] cookies = request.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			if (!cookies[i].getName().equals("JSESSIONID")) {
				out.print(cookies[i].getName() + " : ");
				out.print(cookies[i].getValue() + "<br>");
			}
		}
%>
<br><br>

<a href="/shop/product" title="제품조회">제품조회</a>
<a href="/shop/customer" title="고객조회">고객조회</a>
<br>
<a href="/shop/city" title="재고조회">지역별 제품 재고 현황 조회</a>

<br><br>

    <form method="post" action="searchproduct.jsp">
        제품검색 : <input type="text" name="name">
        <input type="submit" value="조회하기">
    </form>
<br>

    <form method="post" action="searchcustomer.jsp">
        고객검색 : <input type="text" name="name">
        <input type="submit" value="조회하기">
    </form>

</body>
</html>