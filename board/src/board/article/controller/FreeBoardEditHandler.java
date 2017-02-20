package board.article.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.article.service.FreeBoardService;
import mvc.command.CommandHandler;

public class FreeBoardEditHandler implements CommandHandler {

	private FreeBoardService service = new FreeBoardService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String articleNo = req.getParameter("articleNo");
		String articleTitle = req.getParameter("articleTitle");
		String articleContent = req.getParameter("articleContent");
		service.editFreeBoardByArticleNo(Integer.parseInt(articleNo), articleTitle, articleContent);
		req.setAttribute("isRead", "false");
		return new FreeBoardReadHandler().process(req, res);
	}

}
