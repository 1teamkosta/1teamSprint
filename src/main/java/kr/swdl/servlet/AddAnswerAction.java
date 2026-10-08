package kr.swdl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import kr.swdl.model.QnAService;

public class AddAnswerAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		//String memberNumber = (String) request.getSession().getAttribute("memberNumber");
		String questionNumber = request.getParameter("questionNumber");
		String content = request.getParameter("content");
		
		String memberNumber = "M1";
		
		new QnAService().addAnswer(memberNumber, questionNumber, content);
		
		QnAService service = new QnAService();
		request.setAttribute("question", service.getQnA(questionNumber));
		request.setAttribute("answer", service.getAnswer(questionNumber));
		
		return "view/qna.jsp";
	}

}
