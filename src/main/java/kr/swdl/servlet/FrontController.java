package kr.swdl.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Controller")
public class FrontController extends HttpServlet {
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//cmd
		String cmd = request.getParameter("cmd");
		System.out.println("cmd : " + cmd);
		//해당 Action 전달 받아서 실행(TDD 추론해서 필요하다 하면 코드를 만드는 것)
		Action a = ActionFactory.getAction(cmd);
		//해당 페이지로 이동 
		String url = a.execute(request);
		
		request.getRequestDispatcher("/"+url).forward(request, response);
	}

}