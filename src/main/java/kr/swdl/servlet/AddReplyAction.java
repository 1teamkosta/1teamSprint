package kr.swdl.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.swdl.model.TradeService;


public class AddReplyAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {

        TradeService service = new TradeService();
        
        //request.getSession().setAttribute("memberNumber", "M5");
		String memberNumber = (String) request.getSession().getAttribute("memberNumber");
        String tradeNumber = request.getParameter("tradeNumber");
        String content = request.getParameter("content");
        
        service.addTradeReply(tradeNumber, memberNumber, content);

        request.setAttribute("url", "Controller?cmd=viewTrade&tradeNumber=" + tradeNumber);
		
        return "view/redirect.jsp";	
	}

}
