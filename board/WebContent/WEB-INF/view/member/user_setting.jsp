<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h3><i class="fa fa-angle-right"></i> 프로필 수정</h3>
<div class="row mt">
	<div class="col-lg-12">
		<div class="form-panel">
			<h4 class="mb"><i class="fa fa-angle-right"></i> 사용자 정보</h4>
			<form class="form-horizontal style-form" name="" id="" action="" method="post">
				<div class="form-group">
					<label for="inputId" class="col-sm-2 col-sm-2 control-label">아이디</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="memberId" name="memberId" readonly="readonly" value="" required="required">
					</div>
				</div>
				<div class="form-group">
					<label for="inputName" class="col-sm-2 col-sm-2 control-label">이름</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="memberName" name="memberName" value="" required="required">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPhoneNumber" class="col-sm-2 col-sm-2 control-label">휴대폰 번호</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="memberphone" name="memberphone" value="" required="required">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label">현재 비밀번호</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="oldPassword" name="oldPassword" required="required">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label">새 비밀번호</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="newPassword1" name="newPassword1" required="required">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 col-sm-2 control-label">새 비밀번호 확인</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="newPassword2" name="newPassword2" required="required">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-10">
						<input type="submit" class="btn btn-warning" id="profileUpdateBtn" value="프로필 수정">
					</div>
				</div>
			</form>
		</div>
	</div>
</div>