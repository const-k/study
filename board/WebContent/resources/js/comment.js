function insertComment() {
	// 댓글 내용이 필수이므로 검사
	if ($('#content').val() == "") {
		alert("댓글이 없습니다.. 댓글을 입력하세요!");
		$('#content').focus();
		return;
	}
	
	// 버튼 중복 클릭 방지
	$('#insertCommentBtn').attr('disabled', 'disabled');
	
	$("#frm").get(0).action = "/commentWrite.do";
	$("#frm").get(0).submit();
}

$(document).on('click', '.post-description > #stat > a', function() {
	if ($(this).attr("name") == "pDel") {
		$("#commentNo").val($(this).next().val());
		$("#frm").get(0).action = "/commentDelete.do";
		$("#frm").get(0).submit();
	} else if ($(this).attr("name") == "pEdit") {
		// 자기 부모의 tr을 알아낸다.
		var parentElement = $(this).parent().parent(); // <div class="post-description"> ... </div>
		
		// 기존 입력 되있던 댓글내용과 commentNo 추출
		var text = $(this).parent().prev().text();
		var commentNo = $(this).next().next().val();
		console.log(text);
		console.log(commentNo);
		
		// 수정할 댓글의 no를 저장
		$("#commentNo").val(commentNo);
		
		// 부모의 하단에 댓글편집 창을 삽입
		var commentEditor = "<textarea class='form-control' rows='3' id='commentContent2' name='commentContent2'>"
				+ text + "</textarea><br>&nbsp;"
				+ "<a class='btn btn-warning btn-xs' id='cUpdateBtn'><i class='fa fa-pencil'></i> 수정</a>&nbsp;"
				+ "<a class='btn btn-default btn-xs' id='cCancelBtn'><i class='fa fa-trash-o'></i> 취소</a>";
		parentElement.after(commentEditor);

		// 기존 댓글의 폼을 없앤다.
		parentElement.remove();
	} else if ($(this).attr("name") == "pComment") {
		// 자기 부모의 tr을 알아낸다.
		var parentElement = $(this).parent().parent(); // <div class="post-description"> ... </div>
		
		// parentCommentNo 셋팅
		var commentNo = $(this).next().next().next().val();
		console.log(commentNo);
		$("#parentCommentNo").val(commentNo);
		
		// 대댓글임을 표시
		$("#isParentComment").val("false");
		
		// 부모의 하단에 대댓글 창을 삽입
		var commentEditor = "<textarea class='form-control' rows='3' id='commentContent3' name='commentContent3'></textarea><br>&nbsp;"
				+ "<a class='btn btn-warning btn-xs' id='cInsertBtn'><i class='fa fa-pencil'></i> 쓰기</a>&nbsp;"
				+ "<a class='btn btn-default btn-xs' id='cCancelBtn'><i class='fa fa-trash-o'></i> 취소</a>";
		parentElement.after(commentEditor);
		
		
	}
	
	// 댓글 수정폼 없애기
	$("#cCancelBtn").on('click', function() {
		$("#frm").get(0).action = "/freeBoardRead.do";
		$("#frm").get(0).submit();
	});
	
	// 댓글 수정
	$("#cUpdateBtn").on('click', function() {
		$("#frm").get(0).action = "/commentEdit.do";
		$("#frm").get(0).submit();
	});
	
	// 대댓글 입력
	$("#cInsertBtn").on('click', function() {
		$("#frm").get(0).action = "/commentWrite.do";
		$("#frm").get(0).submit();
	});
});