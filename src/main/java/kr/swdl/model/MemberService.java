package kr.swdl.model;

import java.sql.SQLException;

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
}
