package kr.swdl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.swdl.model.TradeService;
import kr.swdl.model.TradeVO;
//댓글목록+댓글수+조회수 추가 
public class ViewTradeUIAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		HttpSession session = request.getSession();
		

        String userId = (String) session.getAttribute("loginOK");
        String memberNumber = (String) session.getAttribute("memberNumber");
        System.out.println("=== ViewTradeUIAction 실행 ===");
        System.out.println("세션 userId (loginOK): " + userId);
        
        if (userId == null) {
            return "view/login.jsp"; 
        }
       
		
		String tradeNumber = request.getParameter("tradeNumber");
        System.out.println("전달받은 tradeNumber: " + tradeNumber);

		TradeService service = new TradeService();
		TradeVO trade = service.getTrade(tradeNumber);
		request.setAttribute("trade", trade);





		return "view/bizTradingDetails.jsp";
	}

}
