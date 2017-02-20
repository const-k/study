<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
	function openEditForm() {
		var detailForm = document.getElementById("detailForm");
		var editForm = document.getElementById("editForm");
		detailForm.style.display="none";
		editForm.style.display="";
	}
	function openDetailForm() {
		var detailForm = document.getElementById("detailForm");
		var editForm = document.getElementById("editForm");
		detailForm.style.display="";
		editForm.style.display="none";
	}
</script>
<!-- detailForm start -->
<div class="col-lg-12" id="detailForm">
	<div class="row">
		<div class="col-md-12">
			<h3><i class="fa fa-angle-right"></i> 자유 게시판</h3>
			<form id="frm" name="frm" method="post">
				<!-- login 기능 구현되면 수정필요!! -->
				<input type="hidden" id="memberNo" name="memberNo" value="1">
				<input type="hidden" name="articleNo" value="${ freeBoardDetail.articleNo }">
				<input type="hidden" id="commentNo" name="commentNo" value="">
				<input type="hidden" id="parentCommentNo" name="parentCommentNo" value="0">
				<input type="hidden" id="isRead" name="isRead" value="false">
				<input type="hidden" id="isParentComment" name="isParentComment" value="true">
				<div class="content-panel">
					<table class="table">
					
						<!-- board content area -->
						<tr>
							<td>
								<span>#${ freeBoardDetail.articleNo }</span>
								<div style="float: right;">
									<a href="javascript:openEditForm();" class="btn btn-default">Edit</a>
									<a href="/freeBoardDelete.do?articleNo=${ freeBoardDetail.articleNo }" class="btn btn-danger">Delete</a>
								</div>
							</td>
						</tr>
						<tr>
							<td>
								<h3><span>${ freeBoardDetail.articleTitle }</span></h3><br>
								<h4><span>${ freeBoardDetail.articleContent }</span></h4><br>
								<a href="#" style="color: #4d94c4"><i class="fa fa-paperclip" aria-hidden="true"></i>파일명</a> 
								<p>(4353kb)</p>
							</td>
						</tr>
						<tr>
							<td>
								<div class="input-group">
									<input class="form-control" placeholder="Add a comment" type="text" id="commentContent" name="commentContent"> 
									<span class="input-group-addon" onclick="insertComment()" style="cursor: pointer;">
										<a href="#"><i class="fa fa-edit"></i></a>
									</span>
								</div>
							</td>
						</tr>
						<!-- // board content area -->
						
						<!-- comment area -->
						<c:if test="${ not empty freeBoardDetail.commentList }">
							<c:forEach var="comment" items="${ freeBoardDetail.commentList }">
								<tr>
									<td>
										<div class="list-group">
											<div class="panel panel-white post">
												<div class="post-heading" id="">
													<div class="pull-left image" style="text-align: center">
														<div class="img-circle" style="background-color: #ff00ff; width:60px; height:60px; line-height:60px;">
															<span style="font-size: 15px; color: #E8E8E8;">ICON</span>
														</div>
													</div>
													<div class="pull-left meta" style="padding-left: 7px">
														<div class="title h5">
															<a href="#"><b>${ comment.memberName }</b></a> made a comment.
														</div>
														<h6 class="text-muted time">${ comment.updatedDate }</h6>
													</div>
												</div>
												<div class="post-description">
													<span>${ comment.commentContent }</span>
													<div class="stats" id="stat">
														<a class="btn btn-success btn-xs" role="button" name="pComment"><i class="fa fa-pencil"></i> 답글</a>
														<a class="btn btn-warning btn-xs" role="button" name="pEdit"><i class="fa fa-pencil"></i> 수정</a>
														<a class="btn btn-theme04 btn-xs" role="button" name="pDel"><i class="fa fa-trash-o"></i> 삭제</a>
														<input type="hidden" name="cno" id="cno" value="${comment.commentNo}">
													</div>
												</div>
											</div>
										</div>
									</td>
								</tr>
							</c:forEach>
						</c:if>
						<!-- // comment area -->
						
					</table>
				</div>
			</form>
		</div>
	</div>
</div>
<!-- // detailForm start -->

<!-- editForm -->
<div class="col-lg-12" id="editForm" style="display: none;">
	<div class="row">
		<div class="col-md-12">
			<h3><i class="fa fa-angle-right"></i> 자유 게시판</h3>
			<div class="form-panel">
				<form class="form-horizontal" method="post" action="freeBoardEdit.do">
					<input type="hidden" name="articleNo" value="${ freeBoardDetail.articleNo }">
					<fieldset>
						<div class="form-group">
							<label for="inputTitle" class="col-lg-1 control-label">제목</label>
							<div class="col-lg-10">
								<input type="text" class="form-control" id="articleTitle" name="articleTitle" placeholder="제목" value="${ freeBoardDetail.articleTitle }" required="required" maxlength="100">
							</div>
						</div>
						<div class="form-group">
							<label for="inputDesc" class="col-lg-1 control-label">내용</label>
							<div class="col-lg-10">
								<textarea class="form-control" rows="8" id="articleContent" name="articleContent" required="required">${ freeBoardDetail.articleContent }</textarea>
								<!-- <span class="help-block">help 설명</span> -->
								
								<!-- File Upload -->
								<section id="filecontent">
									<input type="file" id="" name="">
									<span class="help-block">파일 첨부는 최대 n개 입니다.</span>
								</section>
								<!-- // File Upload -->
								
							</div>
						</div>
						<br>
						<div class="form-group">
							<div class="col-lg-10 col-lg-offset-1">
								<button type="button" class="btn btn-default" onclick="javascript:openDetailForm();">취소</button>
								<button type="submit" id="submit" class="btn btn-primary">수정</button>
							</div>
						</div>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
</div>
<!-- // editForm -->