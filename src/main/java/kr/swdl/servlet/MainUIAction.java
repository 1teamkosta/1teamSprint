package kr.swdl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import kr.swdl.model.MemberService;

public class MainUIAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		String name = new MemberService().memberLogin(request.getParameter("id"), request.getParameter("pw"));
		if (name == null)
			return "view/login.jsp";
		else
			return "view/bizMain.jsp";
	}

}
