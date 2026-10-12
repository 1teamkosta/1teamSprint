package kr.swdl.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import kr.swdl.model.QnAListService;
import kr.swdl.model.QnAVO;
import kr.swdl.model.TradeListService;
import kr.swdl.model.TradeVO;

public class HomeUIAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TradeListService tradeService = new TradeListService();
		QnAListService service = new QnAListService();

		List<TradeVO> tradeList = tradeService.getTradeList(1); // 1페이지 데이터 조회
		List<QnAVO> qnaList = service.getQuestions(1);
		request.setAttribute("listQnA", qnaList);

		request.setAttribute("tradeList", tradeList);
		return "view/bizMain.jsp";
	}

}
