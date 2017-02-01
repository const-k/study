<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-lg-12">
	<div class="row">
		<div class="col-md-12">
			<h3><i class="fa fa-angle-right"></i> 자유 게시판</h3>
			<div class="form-panel">
				<form class="form-horizontal" method="post" action="">
					<fieldset>
						<div class="form-group">
							<label for="inputTitle" class="col-lg-1 control-label">제목</label>
							<div class="col-lg-10">
								<input type="text" class="form-control" id="" name="" placeholder="제목" value="" required="required" maxlength="100">
							</div>
						</div>
						<div class="form-group">
							<label for="inputDesc" class="col-lg-1 control-label">내용</label>
							<div class="col-lg-10">
								<textarea class="form-control" rows="8" id="" name="" required="required"></textarea>
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
								<button type="reset" class="btn btn-default">취소</button>
								<button type="submit" id="submit" class="btn btn-primary">글쓰기</button>
							</div>
						</div>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
</div>