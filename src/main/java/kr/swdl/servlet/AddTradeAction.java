package kr.swdl.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.swdl.model.TradeService;

public class AddTradeAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		
		TradeService service = new TradeService();
		
		String memberNumber = (String) request.getSession().getAttribute("memberNumber");
		String mainImage = request.getParameter("mainImage");
		String title = request.getParameter("title");
		String priceStr = request.getParameter("price");
		String content = request.getParameter("content");
		
		int price;
		try {
		    price = Integer.parseInt(priceStr);
		} catch (NumberFormatException e) {
		    return null;
		}
		
		boolean result = service.addTrade(memberNumber, mainImage, title, price, content);

		return "view/bizTrading.jsp";
	}

}
