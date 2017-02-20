package board.article.service;

import java.sql.Connection;
import java.util.List;

import board.article.dao.FreeBoardDao;
import board.article.vo.Article;
import jdbc.connection.ConnectionProvider;
import util.PageBean;
import util.PageUtility;

public class FreeBoardService {

	private FreeBoardDao articleDao = new FreeBoardDao();

	public void insertFreeArticle(Article article) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			articleDao.insertFreeArticle(conn, article);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Article> getFreeBoardList(PageBean bean) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			int total = articleDao.getFreeBoardTotalCount(conn, bean);
			PageUtility bar = new PageUtility(bean.getInterval(), total, bean.getPageNo());
			bean.setPageLink(bar.getPageBar());
			return articleDao.getFreeBoardList(conn, bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Article getFreeBoardByArticleNo(int articleNo, boolean isRead) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			return articleDao.getFreeBoardByArticleNo(conn, articleNo, isRead);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void increaseReadCount(int articleNo) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			articleDao.increaseReadCount(conn, articleNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void editFreeBoardByArticleNo(int articleNo, String articleTitle, String articleContent) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			articleDao.editFreeBoardByArticleNo(conn, articleNo, articleTitle, articleContent);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteFreeBoardByArticleNo(int articleNo) {
		try (Connection conn = ConnectionProvider.getConnection()) {
			articleDao.deleteFreeBoardByArticleNo(conn, articleNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
