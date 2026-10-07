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
		
		// 3. 파라미터가 존재하는 경우 int형으로 변환
        if (pageParam != null && !pageParam.trim().isEmpty()) {
            try {
                page = Integer.parseInt(pageParam); // "2" -> 숫자 2로 변환
            } catch (NumberFormatException e) {
                page = 1; // 숫자가 아닌 이상한 값이 들어오면 예외 처리하여 1로 고정
            }
        }
        
		TradeListService service = new TradeListService();
        List<TradeVO> list = service.getTradeList(page);
        
        request.setAttribute("currentPage", page);
        request.setAttribute("tradingList", list);
        
        
		return "view/bizTrading.jsp";
	}
}
