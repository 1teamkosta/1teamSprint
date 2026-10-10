package kr.swdl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import kr.swdl.model.QnAService;

public class SetQnaUIAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {

        String questionNumber = request.getParameter("questionNumber");

        request.setAttribute("fix",new QnAService().getQnA(questionNumber));
        
		return "view/qnaWrite.jsp";
	}

}
