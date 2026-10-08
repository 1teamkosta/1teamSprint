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
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		String phone = phone1 + phone2 + phone3;
		String email = request.getParameter("emailId");
		String emailDomain = request.getParameter("emailDomain");
//		API 연결하면 쓸거임...
//		String signupFile = request.getParameter("signupFile");
//		String city;
//		String address1;
//		String address2;
//		String documentNumber;
//		String companyName;
//		String companyNumber;
//		String businessType;
//		String memberName;
		String url = "view/signUp.jsp";

		// #TODO null값 나중에 orc API 사용해서 넣어야함
		if (new MemberService().addMemberInfo(userId, password, nickname, phone, email, emailDomain, " ", " ", " ", " ",
				" ", " ", " ", " ")) {
			request.setAttribute("list", new MemberService().getMembers());
			url = "view/login.jsp";
		}

		return url;
	}

}
