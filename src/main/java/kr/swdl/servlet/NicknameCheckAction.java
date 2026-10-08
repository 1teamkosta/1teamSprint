package kr.swdl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import kr.swdl.model.MemberService;

public class NicknameCheckAction implements Action {

    @Override
    public String execute(HttpServletRequest request)
            throws ServletException, IOException {

        String nickname = request.getParameter("nickname");

        System.out.println("1. 전달받은 닉네임: " + nickname);

        boolean nicknameCheck = new MemberService()
                .isNicknameCheck(nickname);

        System.out.println("2. 중복 검사 결과: " + nicknameCheck);

        request.setAttribute("nicknameCheck", nicknameCheck);

        return "view/nicknameCheckResult.jsp";
    }
}
