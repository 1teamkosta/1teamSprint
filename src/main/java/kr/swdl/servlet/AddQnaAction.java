package kr.swdl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import kr.swdl.model.QnAService;

public class AddQnaAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		//String memberNumber = (String) request.getSession().getAttribute("memberNumber");
		String memberNumber = "M1";
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		new QnAService().addQnA(memberNumber, title, content);
		
		
		return "view/qna.jsp";
	}

}
