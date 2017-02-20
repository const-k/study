package board.comment.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.article.controller.FreeBoardReadHandler;
import board.comment.service.CommentService;
import board.comment.vo.Comment;
import mvc.command.CommandHandler;

public class CommentEditHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String commentContent = req.getParameter("commentContent2");
		String commentNo = req.getParameter("commentNo");
		
		Comment comment = new Comment();
		comment.setCommentContent(commentContent);
		comment.setCommentNo(Integer.parseInt(commentNo));
		
		CommentService commentService = new CommentService();
		commentService.editComment(comment);
		req.setAttribute("isRead", "false");
		
		return new FreeBoardReadHandler().process(req, res);
	}

}
