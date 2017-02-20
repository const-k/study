package board.article.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.article.service.FreeBoardService;
import board.article.vo.Article;
import mvc.command.CommandHandler;

public class FreeBoardDeleteHandler implements CommandHandler {

	private FreeBoardService service = new FreeBoardService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String articleNo = req.getParameter("articleNo");
		service.deleteFreeBoardByArticleNo(Integer.parseInt(articleNo));
		return new FreeBoardListHandler().process(req, res);
	}

}
