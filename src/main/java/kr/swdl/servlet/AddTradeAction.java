package kr.swdl.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.swdl.model.MemberService;
import kr.swdl.model.TradeService;

public class AddTradeAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
        
        String userId = (String) session.getAttribute("loginOK");
        String memberNumber = (String) session.getAttribute("memberNumber");
        
        if (userId == null) {
            return "view/login.jsp"; 
        }
		
		TradeService service = new TradeService();
		
		//String memberNumber = (String) request.getSession().getAttribute("memberNumber");
		String mainImage = request.getParameter("mainImage");
		String title = request.getParameter("title");
		String priceStr = request.getParameter("price");
		String content = request.getParameter("content");

		if (mainImage == null || mainImage.trim().isEmpty()) {
		    mainImage = "default.jpg"; // 또는 DB에 지정할 기본 이미지파일명
		}
		int price;
		try {
		    price = Integer.parseInt(priceStr);
		} catch (NumberFormatException e) {
		    return null;
		}
		
		String tradeNum = service.addTrade(mainImage, title, price, content, memberNumber);
		
		request.setAttribute("url", "Controller?cmd=viewTrade&tradeNumber=" + tradeNum);
		
		return "view/redirect.jsp";
	}

}
