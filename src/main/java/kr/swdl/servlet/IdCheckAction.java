package kr.swdl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import kr.swdl.model.MemberService;

public class IdCheckAction implements Action {

	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {

	        String userId = request.getParameter("userId");

	        System.out.println("1. 전달받은 아이디: " + userId);

	        boolean idCheck = new MemberService()
	                .isIdCheck(userId);

	        System.out.println("2. 중복 검사 결과: " + idCheck);

	        request.setAttribute("idCheck", idCheck);

	        return "view/idCheckResult.jsp";
	}

}
