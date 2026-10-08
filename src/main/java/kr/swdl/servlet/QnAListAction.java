package kr.swdl.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import kr.swdl.model.Common;
import kr.swdl.model.QnAListService;
import kr.swdl.model.QnAVO;

public class QnAListAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		QnAListService service = new QnAListService();
		int questionCnt = 0;
		int curPage = Integer.parseInt(request.getParameter("page"));
		String searchSelect = request.getParameter("searchSelect");
		String keyword = request.getParameter("keyword");
		List<QnAVO> list = null;
		
		if(keyword == null || keyword.trim().isEmpty()) {
			searchSelect = "";
			questionCnt = service.getQuestionCount();
		}
		else {
			questionCnt = service.getQuestionCountSearchByKeyword(searchSelect, keyword);
		}
		
		switch(searchSelect) {
		case "title":
			list = service.getQuestionsSearchByTitle(curPage, keyword);
			break;
		case "author":
			list = service.getQuestionsSearchByNickname(curPage, keyword);
			break;
		case "content":
			list = service.getQuestionsSearchByContent(curPage, keyword);
			break;
		case "titleContent":
			list = service.getQuestionsSearchByTitleOrContent(curPage, keyword);
			break;
		case "":
		default:
			list = service.getQuestions(curPage);
			break;
		}
		
		request.setAttribute("listQnA", list);
		request.setAttribute("totalPage", (int)Math.ceil((double)questionCnt / Common.PAGESIZE));
		request.setAttribute("curPage", curPage);
		return "view/qnaList.jsp";
	}
}
