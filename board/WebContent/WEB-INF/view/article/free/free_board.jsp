<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="pageBean" class="util.PageBean" scope="request" />
<h3><i class="fa fa-angle-right"></i> 자유 게시판</h3>
<div class="col-lg-12">
	<div class="row">
		<div class="col-md-12">
			<form name="free" id="free" method="POST">
				<input type="hidden" name="pageNo" id="pageNo" value="${pageBean.pageNo}" />
				<div class="content-panel">
					<table class="table table-striped table-advance table-hover">
					<h4><i class="fa fa-angle-right"></i> 자유 게시판 # 1</h4>
					<hr>
					<thead>
					<tr>
						<th>#</th>
						<th><i class="fa fa-bullhorn"></i> 제목</th>
						<th class="hidden-phone"><i class="fa fa-question-circle"></i> 글쓴이</th>
						<th><i class="fa fa-bookmark"></i> 조회수</th>
						<th><i class=" fa fa-edit"></i> 등록일</th>
					</tr>
					</thead>
					<tbody>
					<c:forEach var="free" items="${ freeBoardList }">
						<tr>
							<td>${ free.articleNo }</td>
							<td><a href="freeBoardRead.do?articleNo=${ free.articleNo }">${ free.articleTitle }</a></td>
							<td>${ free.memberName }</td>
							<td>${ free.readCnt }</td>
							<td>${ free.updatedDate }</td>
						</tr>
					</c:forEach>
					</tbody>
					</table>
					
					<!-- paging -->
					<div align="center">
						${pageBean.pageLink}
						<a href="/freeBoardWrite.do" class="btn btn-success" style="position: absolute; right: 50px;">글쓰기</a>	
					</div>
					<!-- // paging -->
				</div>
				<!-- /content-panel -->
			</form>
		</div>
	</div>
</div>
<script>
function pageList(page) {
	$("#pageNo").val(page);
	$("#free").get(0).action = "/freeBoardList.do";
	$("#free").get(0).submit();
}
</script>