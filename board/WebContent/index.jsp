<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>커뮤니티 게시판</title>

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

<!-- header include -->
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/view/common/header.jsp" />
<!-- // header include -->

<!-- sidebar include -->
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/view/common/sidebar.jsp" />
<!-- // sidebar include -->

<!-- main content start -->
<!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
	<section id="main-content">
		<section class="wrapper">
			<!-- 여기에 내용만 바뀌게 include -->
			<jsp:include page="${pageContext.request.contextPath}/WEB-INF/view/common/main_content.jsp" />
		</section>
	</section>
<!-- // main content end -->

<!-- footer include -->
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/view/common/footer.jsp" />
<!-- // footer include -->

<!-- common js include -->
<jsp:include page="${pageContext.request.contextPath}/WEB-INF/view/common/js_import.jsp" />
<!-- // common js include -->

<script>
	jQuery(document).ready(function() {
		TaskList.initTaskWidget();
	});

	$(function() {
		$( ".sortable-ui" ).sortable();
		$( ".sortable-ui" ).disableSelection();
	});
</script>

</body>
</html>