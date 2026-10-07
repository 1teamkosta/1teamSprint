package kr.swdl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.swdl.model.MemberService;

@WebServlet("/Controller")
public class LoginAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		
		String url = "view/login.jsp";
		String name = new MemberService().memberLogin(request.getParameter("userId"), request.getParameter("password"));
		if (name != null) {
			url = "view/bizMain.jsp"; 
		}
		HttpSession session = request.getSession(true);
		
		session.setAttribute("loginOK", request.getParameter("id"));
		session.setAttribute("loginName", name);
		
		
		return url;
	}

}
