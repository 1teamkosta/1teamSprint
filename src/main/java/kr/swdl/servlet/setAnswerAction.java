package kr.swdl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import kr.swdl.model.QnAService;

public class setAnswerAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		String answerNumber = request.getParameter("answerNumber");
		String content = request.getParameter("content");
		new QnAService().setAnswer(answerNumber, content);
		
		String questionNumber = request.getParameter("questionNumber");
		QnAService service = new QnAService();
		request.setAttribute("question", service.getQnA(questionNumber));
		request.setAttribute("answer", service.getAnswer(questionNumber));
		
		return "view/qna.jsp";
	}

}
