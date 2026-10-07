package kr.swdl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import kr.swdl.model.MemberService;

public class signUpAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String nickname = request.getParameter("nickname");
		String phone = request.getParameter("phone1")+request.getParameter("phone2")+request.getParameter("phone3");
		String email = request.getParameter("emailIid");
		String emailDomain =request.getParameter("emailDomain");
		String signupFile = request.getParameter("signupFile");
		String city;
		String address1;
		String address2;
		String documentNumber;
		String companyName;
		String companyNumber;
		String businessType;
		String memberName;
		String url = "view/signUp.jsp";
		
		//#TODO null값 나중에 orc API 사용해서 넣어야함
		if (new MemberService().addMemberInfo(userId, password, nickname, phone, email, emailDomain, null, null, null, null,null, null, null, null)) {
			request.setAttribute("list", new MemberService().getMembers());
			url = "view/login.jsp";
		}
		
			
		return url;
	}

}
