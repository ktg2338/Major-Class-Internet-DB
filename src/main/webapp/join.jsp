<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<link rel="stylesheet" type="text/css" href="myCSS.css">
<body>
	<form action="joinService" method="post">
		<div>
			<fieldset>
				<legend>
					<h1>ȸ������ ������</h1>
				</legend>
				<table>
					<tr>
						<td>���̵�</td>
						<td><input placeholder="���̵� �Է�" type="text" name="id"></td>
					</tr>
					<tr>
						<td>�н�����</td>
						<td><input placeholder="�н����� �Է�" type="password" name="pw"></td>
					</tr>
					<tr>
						<td>��ȭ��ȣ</td>
						<td><input placeholder="��ȭ��ȣ �Է�" type="text" name="tel"></td>
					</tr>
					<tr>
						<td colspan=2><input type="submit" value="ȸ������"><input
							type="reset" value="�ʱ�ȭ"></td>
					</tr>
				</table>

			</fieldset>
		</div>
	</form>
</body>
</html>