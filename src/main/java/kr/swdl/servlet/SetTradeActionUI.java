package kr.swdl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.swdl.model.TradeService;
import kr.swdl.model.TradeVO;

public class SetTradeActionUI implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String tradeNumber = request.getParameter("tradeNumber");

        if (tradeNumber != null && !tradeNumber.trim().isEmpty()) {
            TradeService service = new TradeService();
            TradeVO trade = service.getTrade(tradeNumber);
            
            request.setAttribute("fix", trade);
        }

        return "view/tradeWrite.jsp";
    }
}
