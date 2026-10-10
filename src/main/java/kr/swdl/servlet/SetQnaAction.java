package kr.swdl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import kr.swdl.model.QnAService;

public class SetQnaAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		String questionNumber = request.getParameter("questionNumber");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		new QnAService().setQnA(questionNumber, title, content);
		
		request.setAttribute("url", "Controller?cmd=qnaUI&questionNumber="+ questionNumber);
		
		return "view/redirect.jsp";
	}

}
