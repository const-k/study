package board.article.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.article.service.FreeBoardService;
import mvc.command.CommandHandler;

public class FreeBoardReadHandler implements CommandHandler {

	private FreeBoardService service = new FreeBoardService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		boolean isRead = true;
		String articleNum = req.getParameter("articleNo");
		if ((req.getParameter("isRead") != null)) {
			isRead = req.getParameter("isRead").equals("false") ? false : true;
		}
		req.setAttribute("freeBoardDetail", service.getFreeBoardByArticleNo(Integer.parseInt(articleNum), isRead));
		
		return "article/free/detail_board.jsp";
	}

}
