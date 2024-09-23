<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/LTWEB_T3/forgetPassword" method="post">
		<h2>Đổi mật khẩu</h2>
		<label class="input login-input">
			<div class="input-group">
				<span class="input-group-addon"><i class="fa fauser"></i></span> <input
					type="text" placeholder="Tài khoản" name="username"
					class="form-control">
			</div>
		</label> <label class="input login-input">
			<div class="input-group">
				<span class="input-group-addon"><i class="fa fauser"></i></span> <input
					type="text" placeholder="Mật khẩu mới" name="password"
					class="form-control">
			</div>
		</label> <label class="input login-input">
			<div class="input-group">
				<span class="input-group-addon"><i class="fa fauser"></i></span> <input
					type="submit" value="Confirm" class="form-control">
			</div>
		</label>
	</form>
</body>
</html>