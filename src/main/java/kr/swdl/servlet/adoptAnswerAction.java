package kr.swdl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import kr.swdl.model.QnAService;

public class adoptAnswerAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		String answerNumber = request.getParameter("answerNumber");
		String questionNumber = request.getParameter("questionNumber");
		
		new QnAService().adoptAnswer(answerNumber, questionNumber);
		
	    request.setAttribute("question",new QnAService().getQnA(questionNumber));
		request.setAttribute("answer", new QnAService().getAnswer(questionNumber));
		
		return "view/qna.jsp";
	}

}
