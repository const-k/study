package board.article.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.article.service.FreeBoardService;
import board.article.vo.Article;
import mvc.command.CommandHandler;

public class FreeBoardWriteHandler implements CommandHandler {

	private FreeBoardService service = new FreeBoardService();
	private static final String FORM_VIEW = "article/free/write_board.jsp";
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}
	
	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String memberNo = req.getParameter("memberNo");
		String articleTitle = req.getParameter("articleTitle");
		String articleContent = req.getParameter("articleContent");
		String categoryNo = "1";
		
		Article article = new Article();
		article.setArticleTitle(articleTitle);
		article.setArticleContent(articleContent);
		article.setMemberNo(Integer.parseInt(memberNo));
		article.setCategoryNo(Integer.parseInt(categoryNo));
		service.insertFreeArticle(article);
		req.setAttribute("isRead", "false");
		
		return new FreeBoardListHandler().process(req, res);
	}

}
