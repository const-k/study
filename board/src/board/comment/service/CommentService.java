package board.comment.service;

import java.sql.Connection;

import board.comment.dao.CommentDao;
import board.comment.vo.Comment;
import jdbc.connection.ConnectionProvider;

public class CommentService {

	private CommentDao commentDao = new CommentDao();
	
	public void insertComment(Comment comment) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			commentDao.insertComment(conn, comment);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void editComment(Comment comment) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			commentDao.editComment(conn, comment);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteComment(int commentNo) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			commentDao.deleteComment(conn, commentNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
