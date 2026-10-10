package kr.swdl.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import kr.swdl.model.MemberService;
import kr.swdl.model.TradeListService;
import kr.swdl.model.TradeVO;

public class MainUIAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		
		String name = new MemberService().memberLogin(request.getParameter("id"), request.getParameter("pw"));
		if (name == null)
			return "view/login.jsp";
		else {
			
			
			return "view/bizMain.jsp";
		}
	}

}
