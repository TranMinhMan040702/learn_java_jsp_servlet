<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8" />
<title>Đăng nhập</title>
</head>
<body>
	<div class="wrapper fadeInDown">
		<div id="formContent">
			<!-- Tabs Titles -->

			<!-- Icon -->
			<!-- <div class="fadeIn first">
				<img src="http://danielzawadzki.com/codepen/01/icon.svg" id="icon"
					alt="User Icon" />
			</div> -->

			<!-- Login Form -->
			<form action="<c:url value='/dang-nhap'/>" method="post"
				id="formLogin">
				<input type="text" id="userName" class="fadeIn second"
					name="userName" placeholder="Tên đăng nhập" />
				<input type="password" id="password" class="fadeIn third"
					name="password" placeholder="Mật khẩu" /> <input
					type="hidden" value="login" name="action" /> <input type="submit"
					class="fadeIn fourth" value="Log in" />
			</form>

			<!-- Remind Passowrd -->
			<!--<div id="formFooter">
				<a class="underlineHover" href="#">Forgot Password?</a>
			</div>-->
		</div>
	</div>
</body>
</html>
