package board.comment.vo;

public class Comment {

	/*
	 * 	board.comment
	 * 	COMMENT_NO INT AUTO_INCREMENT PRIMARY KEY,
		COMMENT_CONTENT VARCHAR(1000) NOT NULL,
		PARENT_COMMENT_NO INT DEFAULT 0,
		COMMENT_ORDER INT DEFAULT 0,
		ARTICLE_NO INT NOT NULL,
		MEMBER_NO INT NOT NULL,
		IS_DELETE CHAR(1) DEFAULT 'N',
		INSERTED_DATE DATETIME NOT NULL,
		UPDATED_DATE DATETIME NOT NULL
	 */
	private int commentNo;
	private String commentContent;
	private int parentCommentNo;
	private int commentOrder;
	private int articleNo;
	private int memberNo;
	private String isDelete;
	private String insertedDate;
	private String updatedDate;
	
	private String memberName;
	
	public Comment() {}

	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public int getParentCommentNo() {
		return parentCommentNo;
	}

	public void setParentCommentNo(int parentCommentNo) {
		this.parentCommentNo = parentCommentNo;
	}

	public int getCommentOrder() {
		return commentOrder;
	}

	public void setCommentOrder(int commentOrder) {
		this.commentOrder = commentOrder;
	}

	public int getArticleNo() {
		return articleNo;
	}

	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}

	public String getInsertedDate() {
		return insertedDate;
	}

	public void setInsertedDate(String insertedDate) {
		this.insertedDate = insertedDate;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
}
