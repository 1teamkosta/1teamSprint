package kr.swdl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.swdl.model.MemberService;


public class LoginAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		
	    String userId = request.getParameter("userId");
	    String password = request.getParameter("password");
		
		String url = "";
		String name = new MemberService().memberLogin(userId, password);
		 
		 boolean loginSuccess = (name != null);
		 HttpSession session = request.getSession(true);
		if (loginSuccess) {
			
			session.setAttribute("loginOK", userId);
			session.setAttribute("loginName", name);
			url = "view/bizMain.jsp"; 
		}else {
			 session.setAttribute("message", "아이디 또는 비밀번호가 일치하지 않습니다.");
			 url = "view/login.jsp"; 
		}
		request.setAttribute("loginSuccess", loginSuccess);
		
		
		return url;
	}

//public class LoginAction implements Action {
//
//    @Override
//    public String execute(HttpServletRequest request)
//            throws ServletException, IOException {
//
//        String userId = request.getParameter("userId");
//        String password = request.getParameter("password");
//
//        String name = new MemberService()
//                .memberLogin(userId, password);
//
//        boolean loginSuccess = (name != null);
//
//        if (loginSuccess) {
//            HttpSession session = request.getSession(true);
//
//            session.setAttribute("loginOK", userId);
//            session.setAttribute("loginName", name);
//        }
//
//        System.out.println("로그인 결과: " + loginSuccess);
//
//        request.setAttribute("loginSuccess", loginSuccess);
//
//        return "view/loginResult.jsp";
//    }
//

}
