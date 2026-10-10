package kr.swdl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.swdl.model.QnAService;
import kr.swdl.model.QnAVO;
import kr.swdl.model.TradeService;
import kr.swdl.model.TradeVO;

public class ViewQnAUIAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		HttpSession session = request.getSession();


		String userId = (String) session.getAttribute("loginOK");
		String memberNumber = (String) session.getAttribute("memberNumber");
		System.out.println("=== ViewTradeUIAction 실행 ===");
		System.out.println("세션 userId (loginOK): " + userId);

		if (userId == null) {
			return "view/login.jsp"; 
		}


		String questionNumber = request.getParameter("questionNumber");
		System.out.println("전달받은 questionNumber: " + questionNumber);

		QnAService service = new QnAService();
		QnAVO QnA = service.getQnA(questionNumber);
		request.setAttribute("question", QnA);





		return "view/qna.jsp";
	}

}


