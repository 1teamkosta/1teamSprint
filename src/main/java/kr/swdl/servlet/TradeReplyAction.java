package kr.swdl.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.swdl.model.TradeService;


public class TradeReplyAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		
		TradeService service = new TradeService();
		
		String tradeNumber = request.getParameter("tradeNumber");
		String memberNumber = request.getParameter("memberNumber");
		
		return "view/bizTrading.jsp";
	}

}
