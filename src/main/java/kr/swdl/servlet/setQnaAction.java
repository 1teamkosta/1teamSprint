package kr.swdl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import kr.swdl.model.QnAService;

public class setQnaAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		String questionNumber = request.getParameter("questionNumber");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		new QnAService().setQnA(questionNumber, title, content);
		
		QnAService service = new QnAService();
		request.setAttribute("question", service.getQnA(questionNumber));
		request.setAttribute("answer", service.getAnswer(questionNumber));
		
		return "view/qna.jsp";
	}

}
