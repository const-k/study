package board.comment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import board.comment.vo.Comment;
import jdbc.JdbcUtil;

public class CommentDao {
	
	public void insertComment(Connection conn, Comment comment) throws SQLException {
		PreparedStatement stmt = null;
		try {
			int commentOrder = getCommentOrder(conn, comment.getParentCommentNo());
			StringBuilder sql = new StringBuilder();
			sql.append(" INSERT INTO COMMENT(COMMENT_CONTENT, PARENT_COMMENT_NO, COMMENT_ORDER, ARTICLE_NO, MEMBER_NO, INSERTED_DATE, UPDATED_DATE) \n");
			sql.append(" VALUES (?, ?, ?, ?, ?, NOW(), NOW()) ");
			stmt = conn.prepareStatement(sql.toString());
			stmt.setString(1, comment.getCommentContent());
			stmt.setInt(2, comment.getParentCommentNo());
			stmt.setInt(3, commentOrder);
			stmt.setInt(4, comment.getArticleNo());
			stmt.setInt(5, comment.getMemberNo());
			stmt.executeUpdate();
			updateCommentOrder(conn, commentOrder, comment.getParentCommentNo());
		} finally {
			JdbcUtil.close(stmt);
		}
	}
	
	private int getCommentOrder(Connection conn, int parentCommentNo) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT MAX(COMMENT_ORDER) COMMENT_ORDER FROM COMMENT \n");
			sql.append(" WHERE PARENT_COMMENT_NO = ? ");
			stmt = conn.prepareStatement(sql.toString());
			stmt.setInt(1, parentCommentNo);
			rs = stmt.executeQuery();
			if (rs.next()) {
				System.out.println("getCommentOrder()의 parentCommentNo : " + parentCommentNo);
				System.out.println("getCommentOrder()의 COMMENT_ORDER : " + (rs.getInt("COMMENT_ORDER") + 1));
				return rs.getInt("COMMENT_ORDER") + 1;
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
		return 0;
	}

	private void updateCommentOrder(Connection conn, int commentOrder, int parentCommentNo) throws SQLException {
		if (parentCommentNo == 0) {
			return;
		}
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT COMMENT_NO FROM COMMENT \n");
			sql.append(" WHERE COMMENT_ORDER >= ? ");
			stmt = conn.prepareStatement(sql.toString());
			stmt.setInt(1, commentOrder);
			rs = stmt.executeQuery();
			while (rs.next()) {
				System.out.println("updateCommentOrder()의 commentOrder : " + commentOrder);
				System.out.println("updateCommentOrder()의 COMMENT_NO : " + rs.getInt("COMMENT_NO"));
				updateCommentOrderByCommetNo(conn, rs.getInt("COMMENT_NO"));
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}

	private void updateCommentOrderByCommetNo(Connection conn, int commentNo) throws SQLException {
		PreparedStatement stmt = null;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append(" UPDATE COMMENT \n");
			sql.append(" SET COMMENT_ORDER = COMMENT_ORDER + 1 \n");
			sql.append(" WHERE COMMENT_NO = ? ");
			stmt = conn.prepareStatement(sql.toString());
			System.out.println("updateCommentOrderByCommetNo()의 commentNo : " + commentNo);
			stmt.setInt(1, commentNo);
			stmt.executeUpdate();
		} finally {
			JdbcUtil.close(stmt);
		}
	}

	public void editComment(Connection conn, Comment comment) throws SQLException {
		PreparedStatement stmt = null;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append(" UPDATE COMMENT \n");
			sql.append(" SET COMMENT_CONTENT = ?, UPDATED_DATE = NOW() \n");
			sql.append(" WHERE COMMENT_NO = ? ");
			stmt = conn.prepareStatement(sql.toString());
			stmt.setString(1, comment.getCommentContent());
			stmt.setInt(2, comment.getCommentNo());
			stmt.executeUpdate();
		} finally {
			JdbcUtil.close(stmt);
		}
	}
	
	public void deleteComment(Connection conn, int commentNo) throws SQLException{
		PreparedStatement stmt = null;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append(" UPDATE COMMENT \n");
			sql.append(" SET IS_DELETE = 'Y', UPDATED_DATE = NOW() \n");
			sql.append(" WHERE COMMENT_NO = ? ");
			stmt = conn.prepareStatement(sql.toString());
			stmt.setInt(1, commentNo);
			stmt.executeUpdate();
		} finally {
			JdbcUtil.close(stmt);
		}
	}
	
}
