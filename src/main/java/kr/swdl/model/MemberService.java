package kr.swdl.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MemberService {
	public String memberLogin(String id, String pw) {
		try {
			return new MemberDAO(DBCP.getConnection()).memberLogin(id, pw);
		} catch (SQLException e) {
			e.printStackTrace();}
			return null;
	}
	
	public boolean addMemberInfo(
			String memberId,
		    String memberPw,
		    String nickname,
		    String phone,
		    String email,
		    String emailDomain,
		    String documentNumber,
		    String companyName,
		    String companyNumber,
		    String businessType,
		    String memberName,
		    String city,
		    String address1,
		    String address2) {
		try {
			return new MemberDAO(DBCP.getConnection()).addMemberInfo(memberId, memberPw, nickname, phone, email, emailDomain, documentNumber, companyName, companyNumber, businessType, memberName, city, address1, address2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean isNicknameCheck(String nickname) {
		boolean result = false;
		try {
			String check = new MemberDAO(DBCP.getConnection()).isNicknameCheck(nickname);
			if (check != null) result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
		
	}
	
	public boolean isIdCheck(String id) {
		boolean result = false;
		try {
			String check =new MemberDAO(DBCP.getConnection()).isIdCheck(id);
			if (check != null) result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
		
	}
	
	public List<MemberVO> getMembers() {
		try {
			return new MemberDAO(DBCP.getConnection()).getMembers();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
}
