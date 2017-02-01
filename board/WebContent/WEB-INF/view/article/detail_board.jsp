<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-lg-12">
	<div class="row">
		<div class="col-md-12">
			<h3><i class="fa fa-angle-right"></i> 자유 게시판</h3>
			<div class="content-panel">
				<table class="table">
				
					<!-- board content area -->
					<tr>
						<td>
							<span>#256</span>
							<div style="float: right;">
								<a href="#" class="btn btn-default">Edit</a>
								<a href="#" class="btn btn-danger">Delete</a>
							</div>
						</td>
					</tr>
					<tr>
						<td>
							<h3><span>제목</span></h3><br>
							<h4><span>ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ</span></h4><br>
							<a href="#" style="color: #4d94c4"><i class="fa fa-paperclip" aria-hidden="true"></i>파일명</a> 
							<p>(4353kb)</p>
						</td>
					</tr>
					<tr>
						<td>
							<div class="input-group">
								<input class="form-control" placeholder="Add a comment" type="text" id="content" name="content"> 
								<span class="input-group-addon" id="" style="cursor: pointer;">
									<a href="#"><i class="fa fa-edit"></i></a>
								</span>
							</div>
						</td>
					</tr>
					<!-- // board content area -->
					
					<!-- comment area -->
					<tr>
						<td>
							<div class="list-group">
								<div class="panel panel-white post">
									<div class="post-heading" id="commentTable">
										<div class="pull-left image" style="text-align: center">
											<div class="img-circle" style="background-color: #ff00ff; width:60px; height:60px; line-height:60px;">
												<span style="font-size: 15px; color: #E8E8E8;">ICON</span>
											</div>
										</div>
										<div class="pull-left meta" style="padding-left: 7px">
											<div class="title h5">
												<a href="#"><b>userName</b></a> made a comment.
											</div>
											<h6 class="text-muted time">2017-01-29</h6>
										</div>
									</div>
									<div class="post-description">
										<span>코멘트 내용</span>
										<div class="stats" id="stat">
											<a class="btn btn-warning btn-xs" role="button" name="pEdit"><i class="fa fa-pencil"></i> 수정</a>
											<a class="btn btn-theme04 btn-xs" role="button" name="pDel"><i class="fa fa-trash-o"></i> 삭제</a>
										</div>
									</div>
								</div>
							</div>
						</td>
					</tr>
					<!-- // comment area -->
					
				</table>
			</div>
		</div>
	</div>
</div>