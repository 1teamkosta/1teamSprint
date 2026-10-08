package kr.swdl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import kr.swdl.model.TradeService;
import kr.swdl.model.TradeVO;
//댓글목록+댓글수+조회수 추가 
public class ViewTradeUIAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {

		
		String tradeNumber = request.getParameter("tradeNumber");
		TradeService service = new TradeService();
		TradeVO trade = service.getTrade(tradeNumber);
		request.setAttribute("trade", trade);





		return "view/bizTradingDetails.jsp";
	}

}
