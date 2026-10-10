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
		
		request.setAttribute("url", "Controller?cmd=qnaListAction&page=1");
		
		return "view/redirect.jsp";
	}

}
