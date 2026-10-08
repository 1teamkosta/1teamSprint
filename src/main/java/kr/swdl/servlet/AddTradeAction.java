package kr.swdl.servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import kr.swdl.model.TradeService;
import kr.swdl.model.TradeVO;

public class AddTradeAction implements Action {
// 새글 DB -> insert
	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String memberNumber = "M1";
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String mainImage = request.getParameter("mainImage");
		int price = Integer.parseInt(request.getParameter("price"));
		
		
		new TradeService().addTrade(memberNumber, mainImage, title, price, content);
		request.setAttribute("fix", new TradeService().getTrade(memberNumber));

		
		
		return "view/bizTradingDetails.jsp";
	}//css 적용시 사이즈 변경됨 
}

/*TradeService service = new TradeService();

int tradeNumber = service.addTrade(memberNumber, mainImage, title, price, content);
service.addTrade(memberNumber, memberNumber, title, price, content);

TradeVO trade = service.getTrade(memberNumber);

// 5. request 영역에 tradeVO 객체 저장
request.setAttribute("trade", trade);
		

*/
