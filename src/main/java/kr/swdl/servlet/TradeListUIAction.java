package kr.swdl.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

import kr.swdl.model.TradeListService;
import kr.swdl.model.TradeVO;
public class TradeListUIAction implements Action {
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		int page = 1;
		String pageParam = request.getParameter("page");
		
		TradeListService service = new TradeListService();
        List<TradeVO> list = service.getTradeList(page);
        
        request.setAttribute("currentPage", page);
        request.setAttribute("tradingList", list);
        
        
		return "view/bizTrading.jsp";
	}
}
