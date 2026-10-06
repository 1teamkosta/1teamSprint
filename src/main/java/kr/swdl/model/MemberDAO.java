package kr.swdl.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {
	private Connection conn;
	
	public MemberDAO(Connection conn) {
		this.conn = conn;
	}
	
	public String memberLogin(String id, String pw){
		String nickname=null;
		try {
			PreparedStatement pstmt=conn.prepareStatement(Query.MEMBER_LOGIN);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) nickname=rs.getString(1);
			rs.close();
			pstmt.close();
		} catch (SQLException e) {			
			e.printStackTrace();
		}		
		return nickname;
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
		    String address2){
		boolean result=false;
		try {
			PreparedStatement pstmt=conn.prepareStatement(Query.ADD_MEMBER_INFO);
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPw);
			pstmt.setString(3, nickname);
			pstmt.setString(4, phone);
			pstmt.setString(5, email);
			pstmt.setString(6, emailDomain);
			pstmt.setString(7, documentNumber);
			pstmt.setString(8, companyName);
			pstmt.setString(9, companyNumber);
			pstmt.setString(10, businessType);
			pstmt.setString(11, memberName);
			pstmt.setString(12, city);
			pstmt.setString(13, address1);
			pstmt.setString(14, address2);
			result=pstmt.executeUpdate()==1;
			pstmt.close();
		} catch (SQLException e) {			
			e.printStackTrace();
		}		
		return result;
	}
}
