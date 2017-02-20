package board.comment.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.article.controller.FreeBoardReadHandler;
import board.comment.service.CommentService;
import board.comment.vo.Comment;
import mvc.command.CommandHandler;

public class CommentWriteHandler implements CommandHandler {

	CommentService commentService = new CommentService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String isParentComment = req.getParameter("isParentComment");
		String commentContent = "";
		if ("true".equals(isParentComment)) {
			commentContent = req.getParameter("commentContent");
		} else {
			commentContent = req.getParameter("commentContent3");
		}
		String parentCommentNo = req.getParameter("parentCommentNo");
		String articleNo = req.getParameter("articleNo");
		String memberNo = req.getParameter("memberNo");
		
		
		Comment comment = new Comment();
		comment.setCommentContent(commentContent);
		comment.setParentCommentNo(Integer.parseInt(parentCommentNo));
		comment.setArticleNo(Integer.parseInt(articleNo));
		comment.setMemberNo(Integer.parseInt(memberNo));
		commentService.insertComment(comment);
		req.setAttribute("isRead", "false");
		
		return new FreeBoardReadHandler().process(req, res);
	}

}
