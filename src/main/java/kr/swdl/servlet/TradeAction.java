package kr.swdl.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.swdl.model.TradeService;
import kr.swdl.model.TradeVO;

public class TradeAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		
		String tradeNumber = "T5";
		//String tradeNumber = request.getParameter(tradeNumber);
		request.setAttribute("trade", new TradeService().getTrade(tradeNumber));
		
		return "view/bizTradingDetails.jsp";
	}
}
