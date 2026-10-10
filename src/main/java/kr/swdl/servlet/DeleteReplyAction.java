package kr.swdl.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.swdl.model.TradeService;


public class DeleteReplyAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		
		TradeService service = new TradeService();
		
		String tradeNumber = request.getParameter("tradeNumber");
		String replyNumber = request.getParameter("replyNumber");
		
		service.deleteTradeReply(replyNumber);
		
		request.setAttribute("url", "Controller?cmd=viewTrade&tradeNumber=" + tradeNumber);
		
		return "view/redirect.jsp";
	}

}