<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="myCSS.css">
</head>
<body>
	<form action="loginService" method="post">
		<div>
			<fieldset>
				<legend>
					<h1>�α��� ������</h1>
				</legend>
				<table>
					<tr>
						<td>���̵�</td>
						<td><input placeholder="���̵� �Է�" type="text" name="id"></td>
					</tr>
					<tr>
						<td>��й�ȣ</td>
						<td><input placeholder="��й�ȣ �Է�" type="password" name="pw"></td>
					</tr>
					<tr>
						<td colspan="2">
						<input type="submit" value="�α���">
						<input type="reset" value="�ʱ�ȭ">
						</td>
					</tr>
				</table>
			</fieldset>
		</div>
	</form>
</body>
</html>