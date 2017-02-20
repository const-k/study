package board.comment.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.article.controller.FreeBoardReadHandler;
import board.comment.service.CommentService;
import mvc.command.CommandHandler;

public class CommentDeleteHandler implements CommandHandler {

	CommentService commentService = new CommentService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String commentNo = req.getParameter("commentNo");
		
		CommentService commentService = new CommentService();
		commentService.deleteComment(Integer.parseInt(commentNo));
		req.setAttribute("isRead", "false");
		
		return new FreeBoardReadHandler().process(req, res);
	}

}
