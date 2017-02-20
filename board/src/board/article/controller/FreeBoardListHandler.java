package board.article.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.article.service.FreeBoardService;
import mvc.command.CommandHandler;
import util.PageBean;

public class FreeBoardListHandler implements CommandHandler {

	private FreeBoardService service = new FreeBoardService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String word = req.getParameter("word");
		String key = req.getParameter("key");
		String pageNo = req.getParameter("pageNo");
		int pageNum = 0;
		try {
			pageNum = Integer.parseInt(pageNo);
		} catch (Exception e) {
			// page 정보가 전송되지 않은 경우 이므로 첫 페이지로 처리하기 위해서
			pageNum = 1;
		}
		
		// 현재시간 저장
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String nowDate = format.format(date);
		req.setAttribute("nowDate", nowDate);
		
		// 페이징 처리
		PageBean bean = new PageBean(key, word, null, pageNum);
		req.setAttribute("pageBean", bean);
		req.setAttribute("freeBoardList", service.getFreeBoardList(bean));

		return "article/free/free_board.jsp";
	}

}
