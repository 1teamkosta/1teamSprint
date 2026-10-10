package kr.swdl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import kr.swdl.model.TradeService;

public class deleteTradeAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		TradeService service = new TradeService();

		String tradeNumber = request.getParameter("tradeNumber");

		boolean result = service.deleteTrade(tradeNumber);

		return "Controller?cmd=tradeListUI&page=1";}

}
