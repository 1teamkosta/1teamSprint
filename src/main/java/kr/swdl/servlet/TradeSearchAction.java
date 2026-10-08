package kr.swdl.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

import kr.swdl.model.TradeListService;
import kr.swdl.model.TradeVO;
public class TradeSearchAction implements Action {
	
	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		
		int page = 1;
		String searchType = request.getParameter("searchType");
        if (searchType == null || searchType.trim().isEmpty()) {
            searchType = "title"; // 기본 검색 조건을 '제목'으로 지정
        }
		String pageParam = request.getParameter("page");
		String keywordParam = request.getParameter("pageKeyword");
		System.out.println("전달받은 searchType 값: [" + searchType + "]");
		
		List<TradeVO> list = null;

		TradeListService service = new TradeListService();
		switch(searchType) {
		case "title":
	     list = service.getTradeSearhTitle(page, keywordParam);
			break;
		case "author":
			list = service.getTradeNickname(page, keywordParam);
			break;
		case "content":
			list = service.getTradeContent(page, keywordParam);
			break;
		case "titleContent":
			list = service.getTradeTitleContent(page, keywordParam);
			break;       
			default:
				list = service.getTradeSearhTitle(page, keywordParam);
				break;
		}
      // request.setAttribute("currentPage", page);
       request.setAttribute("tradingList", list);
		
		return "view/bizTrading.jsp";
	


}
}