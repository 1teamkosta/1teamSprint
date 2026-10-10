package kr.swdl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import kr.swdl.model.TradeService;

public class SetTradeAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		TradeService service = new TradeService();
		
		//String memberNumber = (String) request.getSession().getAttribute("memberNumber");
		String mainImage = request.getParameter("mainImage");
		String title = request.getParameter("title");
		String priceStr = request.getParameter("price");
		String content = request.getParameter("content");
		String tradeNumber = request.getParameter("tradeNumber");

		if (mainImage == null || mainImage.trim().isEmpty()) {
		    mainImage = "default.jpg"; // 또는 DB에 지정할 기본 이미지파일명
		}
		int price;
		try {
		    price = Integer.parseInt(priceStr);
		} catch (NumberFormatException e) {
		    return null;
		}

		boolean result = service.setTrade(mainImage, title, price, content, tradeNumber);
				
		
		return "Controller?cmd=viewTrade&tradeNumber=" + tradeNumber;	}


}
