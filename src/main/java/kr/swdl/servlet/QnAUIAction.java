package kr.swdl.servlet;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import kr.swdl.model.QnAService;
import kr.swdl.model.QnAVO;

public class QnAUIAction implements Action {
	
	
	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		String questionNumber = "Q6";
		//String questionNumber = request.getParameter(questionNumber);
		request.setAttribute("question", new QnAService().getQnA(questionNumber));
		request.setAttribute("answer", new QnAService().getAnswer(questionNumber));
		
		return "view/qna.jsp";
	}
}
