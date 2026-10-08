package kr.swdl.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.swdl.model.ReplyVO;
import kr.swdl.model.TradeService;
import kr.swdl.model.TradeVO;


public class SetReplyAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		
		TradeService service = new TradeService();

	    String tradeNumber = request.getParameter("tradeNumber");
        String replyNumber = request.getParameter("replyNumber");
        String content = request.getParameter("content");

        service.setTradeReply(replyNumber, content);
        
        request.setAttribute("trade", service.getTrade(tradeNumber));
        
		return "view/bizTradingDetails.jsp";
	}

}
