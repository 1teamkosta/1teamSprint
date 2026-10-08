package kr.swdl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public class TradeWriteUIAction implements Action {
//대표이미지, 글쓰기 라이브러리(api)
	@Override
	public String execute(HttpServletRequest request) throws ServletException, IOException {
		// TODO Auto-generated method stub
		return "view/tradeWrite.jsp";
	}

}
