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


public class TradeSetReplyAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		
		TradeService service = new TradeService();

        String memberNumber = (String) request.getSession().getAttribute("memberNumber");
        String tradeNumber = request.getParameter("tradeNumber");
        String replyNumber = request.getParameter("replyNumber");
        String content = request.getParameter("content");

        // 본인 댓글인지 확인
        TradeVO trade = service.getTrade(tradeNumber);
        boolean mine = false;
        if (trade != null) {
            for (ReplyVO r : trade.getReply()) {
                if (replyNumber.equals(r.getReplyNumber()) && memberNumber.equals(r.getMemberNumber())) {
                    mine = true;
                    break;
                }
            }
        }

        if (mine) {
            service.setTradeReply(replyNumber, content.trim());
        }
		return "view/bizTradingDetails.jsp";
	}

}
