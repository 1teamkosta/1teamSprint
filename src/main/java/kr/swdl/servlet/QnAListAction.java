package kr.swdl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import kr.swdl.model.Common;
import kr.swdl.model.QnAListService;
import kr.swdl.model.QnAService;

public class QnAListAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		QnAListService service = new QnAListService();
		int totalPage = (int)Math.ceil((double)service.getQuestionCount() / Common.PAGESIZE);
		int curPage = Integer.parseInt(request.getParameter("page"));
		
		request.setAttribute("listQnA", service.getQuestions(curPage));
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("curPage", curPage);
		return "view/qnaList.jsp";
	}

}
