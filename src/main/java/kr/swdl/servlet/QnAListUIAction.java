package kr.swdl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import kr.swdl.model.QnAListService;
import kr.swdl.model.QnAService;

public class QnAListUIAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		
		request.setAttribute("listQnA", new QnAListService().getQuestions(1));
		
		return "view/qnaList.jsp";
	}

}
