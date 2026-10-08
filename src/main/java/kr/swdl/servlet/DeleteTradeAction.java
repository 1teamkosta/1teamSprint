package kr.swdl.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.swdl.model.TradeListService;
import kr.swdl.model.TradeService;

public class DeleteTradeAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		
		String tradeNumber = request.getParameter("tradeNumber");
		
		new TradeService().deleteTrade(tradeNumber);
		
		request.setAttribute("trade",new TradeListService().getTradeList(1));
		
		return "view/bizTrading.jsp";
	}

}
