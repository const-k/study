package board.article.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import board.article.vo.Article;
import board.comment.vo.Comment;
import jdbc.JdbcUtil;
import util.PageBean;

public class FreeBoardDao {

	public void insertFreeArticle(Connection conn, Article article) throws SQLException {
		PreparedStatement stmt = null;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append(" INSERT INTO ARTICLE \n");
			sql.append(" (ARTICLE_TITLE, ARTICLE_CONTENT, MEMBER_NO, CATEGORY_NO, INSERTED_DATE, UPDATED_DATE) \n");
			sql.append(" VALUES (?, ?, ?, ?, NOW(), NOW()) ");
			stmt = conn.prepareStatement(sql.toString());
			stmt.setString(1, article.getArticleTitle());
			stmt.setString(2, article.getArticleContent());
			stmt.setInt(3, article.getMemberNo());
			stmt.setInt(4, article.getCategoryNo());
			stmt.executeUpdate();
		} finally {
			JdbcUtil.close(stmt);
		}
	}

	public int getFreeBoardTotalCount(Connection conn, PageBean bean) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String word = bean.getWord();
			String key = bean.getKey();

			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT COUNT(1) CNT FROM ARTICLE A, MEMBER B \n"); 
			sql.append(" WHERE A.MEMBER_NO = B.MEMBER_NO \n ");
			sql.append(" AND A.CATEGORY_NO = 1 \n");
			sql.append(" AND A.IS_DELETE = 'N' \n");
			sql.append(" AND B.IS_DELETE = 'N' \n");
			if (word != null && !word.trim().equals("") && !key.equals("ALL")) {
				if (key.equals("MEMBER_ID")) {
					sql.append(" AND B.MEMBER_ID LIKE ? \n");
				} else if (key.equals("MEMBER_NAME")) {
					sql.append(" AND B.MEMBER_NAME LIKE ? \n");
				} else if (key.equals("ARTICLE_TITLE")) {
					sql.append(" AND A.ARTICLE_TITLE LIKE ? \n");
				} 
			}
			stmt = conn.prepareStatement(sql.toString());
			
			int idx = 1;
			if (word != null && !word.trim().equals("") && !key.equals("ALL")) {
				if (key.equals("MEMBER_ID") || key.equals("MEMBER_NAME") || key.equals("ARTICLE_TITLE")) {
					stmt.setString(idx++, "%" + word + "%");
				} 
			}
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				return rs.getInt("CNT");
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
		return 1;
	}

	public List<Article> getFreeBoardList(Connection conn, PageBean bean) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String key = bean.getKey();
			String word = bean.getWord();
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT A.*, MEMBER_ID, MEMBER_NAME FROM ARTICLE A, MEMBER B \n");
			sql.append(" WHERE A.MEMBER_NO = B.MEMBER_NO \n");
			sql.append(" AND A.CATEGORY_NO = 1 \n");
			sql.append(" AND A.IS_DELETE = 'N' \n");
			sql.append(" AND B.IS_DELETE = 'N' \n");
			if (word != null && !word.trim().equals("") && !key.equals("ALL")) {
				if (key.equals("MEMBER_ID")) {
					sql.append(" AND B.MEMBER_ID LIKE ? \n");
				} else if (key.equals("MEMBER_NAME")) {
					sql.append(" AND B.MEMBER_NAME LIKE ? \n");
				} else if (key.equals("ARTICLE_TITLE")) {
					sql.append(" AND A.ARTICLE_TITLE LIKE ? \n");
				} 
			}
			sql.append(" ORDER BY A.ARTICLE_NO DESC \n");
			sql.append(" LIMIT ?, ? \n");
			stmt = conn.prepareStatement(sql.toString());

			int idx = 1;
			if (word != null && !word.trim().equals("") && !key.equals("all")) {
				if ( key.equals("MEMBER_ID") || key.equals("MEMBER_NAME") || key.equals("ARTICLE_TITLE") ) {
					stmt.setString(idx++, "%" + word + "%");
				} 
			}
			stmt.setInt(idx++, bean.getStart());
			stmt.setInt(idx++, bean.getInterval());
			rs = stmt.executeQuery();
			
			List<Article> list = new ArrayList<Article>();
			while (rs.next()) {
				Article article = new Article();
				article.setArticleTitle(rs.getString("ARTICLE_TITLE"));
				article.setArticleContent(rs.getString("ARTICLE_CONTENT"));
				article.setMemberNo(rs.getInt("MEMBER_NO"));
				article.setCategoryNo(rs.getInt("CATEGORY_NO"));
				article.setArticleNo(rs.getInt("ARTICLE_NO"));
				article.setReadCnt(rs.getInt("READ_CNT"));
				article.setMemberId(rs.getString("MEMBER_ID"));
				article.setMemberName(rs.getString("MEMBER_NAME"));
				article.setUpdatedDate(rs.getString("UPDATED_DATE"));
				list.add(article);
			}
			return list;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}

	public Article getFreeBoardByArticleNo(Connection conn, int articleNo, boolean isRead) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT A.*, MEMBER_ID, MEMBER_NAME FROM ARTICLE A, MEMBER B \n");
			sql.append(" WHERE A.MEMBER_NO = B.MEMBER_NO \n");
			sql.append(" AND ARTICLE_NO = ? \n");
			sql.append(" AND A.CATEGORY_NO = 1 \n");
			sql.append(" AND A.IS_DELETE = 'N' \n");
			sql.append(" AND B.IS_DELETE = 'N' \n");
			
			stmt = conn.prepareStatement(sql.toString());
			stmt.setInt(1, articleNo);
			rs = stmt.executeQuery();
			if (isRead) {
				increaseReadCount(conn, articleNo);
			}
			if (rs.next()) {
				Article article = new Article();
				article.setArticleTitle(rs.getString("ARTICLE_TITLE"));
				article.setArticleContent(rs.getString("ARTICLE_CONTENT"));
				article.setMemberNo(rs.getInt("MEMBER_NO"));
				article.setCategoryNo(rs.getInt("CATEGORY_NO"));
				article.setArticleNo(rs.getInt("ARTICLE_NO"));
				article.setCommentList(getCommentList(conn, articleNo));
				return article;
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
		return null;
	}
	
	public List<Comment> getCommentList(Connection conn, int articleNo) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT A.*, B.MEMBER_NAME FROM COMMENT A, MEMBER B \n");
			sql.append(" WHERE A.MEMBER_NO = B.MEMBER_NO \n");
			sql.append(" AND A.IS_DELETE = 'N' \n");
			sql.append(" AND B.IS_DELETE = 'N' \n");
			sql.append(" AND A.ARTICLE_NO = ? \n");
			sql.append(" ORDER BY COMMENT_ORDER ");
			stmt = conn.prepareStatement(sql.toString());
			
			stmt.setInt(1, articleNo);
			rs = stmt.executeQuery();
			
			List<Comment> commentList = new ArrayList<Comment>();
			while (rs.next()) {
				Comment comment = new Comment();
				comment.setCommentNo(rs.getInt("COMMENT_NO"));
				comment.setCommentContent(rs.getString("COMMENT_CONTENT"));
				comment.setParentCommentNo(rs.getInt("PARENT_COMMENT_NO"));
				comment.setCommentOrder(rs.getInt("COMMENT_ORDER"));
				comment.setArticleNo(rs.getInt("ARTICLE_NO"));
				comment.setMemberNo(rs.getInt("MEMBER_NO"));
				comment.setMemberName(rs.getString("MEMBER_NAME"));
				comment.setUpdatedDate(rs.getString("UPDATED_DATE"));
				commentList.add(comment);
			}
			return commentList;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
	}
	
	public void increaseReadCount(Connection conn, int articleNo) throws SQLException {
		try (PreparedStatement stmt
				= conn.prepareStatement(" UPDATE ARTICLE SET READ_CNT = READ_CNT + 1 WHERE ARTICLE_NO = ? ")) {
			stmt.setInt(1, articleNo);
			stmt.executeUpdate();
		}
	}
	
	public void editFreeBoardByArticleNo(Connection conn, int articleNo, String articleTitle, String articleContent) throws SQLException {
		try (PreparedStatement pstmt
				= conn.prepareStatement(" UPDATE ARTICLE SET ARTICLE_TITLE = ?, ARTICLE_CONTENT = ?, UPDATED_DATE = NOW() "
						+ " WHERE ARTICLE_NO = ? ")) {
			pstmt.setString(1, articleTitle);
			pstmt.setString(2, articleContent);
			pstmt.setInt(3, articleNo);
			pstmt.executeUpdate();
		}
	}
	
	public void deleteFreeBoardByArticleNo(Connection conn, int articleNo) throws SQLException {
		try (PreparedStatement pstmt
				= conn.prepareStatement(" UPDATE ARTICLE SET IS_DELETE = 'Y', UPDATED_DATE = NOW() WHERE ARTICLE_NO = ? ")) {
			pstmt.setInt(1, articleNo);
			pstmt.executeUpdate();
		}
	}
	
}
