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

<a href="/shop/product" title="��ǰ��ȸ">��ǰ��ȸ</a>
<a href="/shop/customer" title="����ȸ">����ȸ</a>
<br>
<a href="/shop/city" title="�����ȸ">������ ��ǰ ��� ��Ȳ ��ȸ</a>

<br><br>

    <form method="post" action="searchproduct.jsp">
        ��ǰ�˻� : <input type="text" name="name">
        <input type="submit" value="��ȸ�ϱ�">
    </form>
<br>

    <form method="post" action="searchcustomer.jsp">
        ���˻� : <input type="text" name="name">
        <input type="submit" value="��ȸ�ϱ�">
    </form>

</body>
</html>