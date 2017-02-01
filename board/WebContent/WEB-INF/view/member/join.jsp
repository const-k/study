<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Dashboard">
<meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
<title>커뮤니티 회원가입</title>

<!-- common css include -->
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/view/common/css_import.jsp" />
<!-- // common css include -->

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->

<div id="login-page">
	<div class="container">
		<form class="form-login" action="" method="post">
			<h2 class="form-login-heading">sign up</h2>
			<div class="login-wrap">
				<input type="text" id="memberId" name="memberId" class="form-control" placeholder="User Id" maxlength="100" required><br>
				<input type="text" class="form-control" id="memberName" name="memberName" placeholder="Name" maxlength="50" required><br>
				<input type="text" class="form-control" id="memberPhone" name="memberPhone" placeholder="Phone Number" maxlength="11" required><br>
				<input type="password" id="memberPassword" name="memberPassword" class="form-control" placeholder="Password" maxlength="20" required><br>
				<div class="login-social-link centered">
					<button class="btn btn-theme" type="submit" style="width: 100px;">
						<i class="fa fa-lock"></i> SIGN UP
					</button>
					<a href="#" class="btn btn-theme03" style="width: 100px;">
						<i class="fa fa-share" aria-hidden="true"></i> BACK
					</a>
				</div>
			</div>
		</form>
	</div>
</div>

<!-- common js include -->
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/view/common/js_import.jsp" />
<!-- // common js include -->
<script>
	$.backstretch("../../resources/images/login-bg.jpg", {speed: 500});
</script>

</body>
</html>