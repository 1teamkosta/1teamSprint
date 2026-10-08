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
		//String questionNumber = request.getParameter(questionNumber);
		//String memberNumber = (String) request.getSession().getAttribute("memberNumber");
		QnAService service = new QnAService();
		String memberNumber = "M1";
		String questionNumber = "Q9";
		
		service.addViewCount(memberNumber, questionNumber);
		
		request.setAttribute("question", service.getQnA(questionNumber));
		request.setAttribute("answer", service.getAnswer(questionNumber));
		
		return "view/qna.jsp";
	}
}
