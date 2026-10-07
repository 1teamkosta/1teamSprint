package kr.swdl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import kr.swdl.model.QnAService;

public class AddAnswerAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		String memberNumber = (String) request.getSession().getAttribute("memberNumber");
		String questionNumber = request.getParameter("questionNumber");
		String content = request.getParameter("content");
		memberNumber = "test";
		new QnAService().addAnswer(memberNumber, questionNumber, content);
		return "view/qna.jsp";
	}

}
