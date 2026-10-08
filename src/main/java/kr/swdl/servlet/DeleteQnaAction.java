package kr.swdl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import kr.swdl.model.QnAService;

public class DeleteQnaAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		String questionNumber = request.getParameter("questionNumber");
		new QnAService().deleteQnA(questionNumber);
		
		QnAService service = new QnAService();
		request.setAttribute("question", service.getQnA(questionNumber));
		request.setAttribute("answer", service.getAnswer(questionNumber));
		
		return "view/bizMain.jsp"; //qnalist로 넘겨야됨
	}

}
