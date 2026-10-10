package kr.swdl.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

import kr.swdl.model.Common;
import kr.swdl.model.TradeListService;
import kr.swdl.model.TradeVO;
public class TradeListUIAction implements Action {
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		/*	TradeListService service = new TradeListService();
		int curPage=1;
		int tradeCnt = 0;
		curPage = Integer.parseInt(request.getParameter("page"));
		tradeCnt = service.getTradeCount();

        List<TradeVO> list = service.getTradeList(curPage);

        request.setAttribute("tradingList", list);
        request.setAttribute("totalPage", (int)Math.ceil((double)tradeCnt / Common.GALARY_PAGESIZE));
		request.setAttribute("curPage", curPage);
		return "view/bizTrading.jsp";

	}
}
		 */




		
		TradeListService service = new TradeListService();
		int tradeCnt = 0;
		int curPage = Integer.parseInt(request.getParameter("page"));
		String searchSelect = request.getParameter("searchSelect");
		String keyword = request.getParameter("keyword");
		List<TradeVO> list = null;

		if(keyword == null || keyword.trim().isEmpty()) {
			searchSelect = "";
			tradeCnt = service.getTradeCount();
		}
		else {
			tradeCnt = service.getTradeCountSearchByKeyword(searchSelect, keyword);
		}

		switch(searchSelect) {
		case "title":
			list = service.getTradeSearhTitle(curPage, keyword);
			break;
		case "author":
			list = service.getTradeNickname(curPage, keyword);
			break;
		case "content":
			list = service.getTradeContent(curPage, keyword);
			break;
		case "titleContent":
			list = service.getTradeTitleContent(curPage, keyword);
			break;
		case "":
		default:
			list = service.getTradeList(curPage);
			break;
		}

		request.setAttribute("tradingList", list);
		request.setAttribute("totalPage", (int)Math.ceil((double)tradeCnt / Common.GALARY_PAGESIZE));
		request.setAttribute("curPage", curPage);
		return "view/bizTrading.jsp";
	}
}