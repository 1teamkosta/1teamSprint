package kr.swdl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import kr.swdl.model.QnAService;

public class DeleteAnswerAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		String answerNumber = request.getParameter("answerNumber");
		String questionNumber = request.getParameter("questionNumber");
		new QnAService().deleteAnswer(answerNumber, questionNumber);
		
		request.setAttribute("url", "Controller?cmd=qnaUI&questionNumber="+questionNumber);
		
		return "view/redirect.jsp";
	}

}
