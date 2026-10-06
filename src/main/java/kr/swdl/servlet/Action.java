package kr.swdl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public interface Action {
// 얘는 뭐가 나올지 몰루긔윤
	
	//request를 전달하고 결과 url을 받는다
	String execute(HttpServletRequest request) throws ServletException, IOException;
	// 이름은 아무거나함... ^^
	// 내가 원하는대로 재배치. 
	
	//앞으로 이거 수정할 일 xx
	
}
