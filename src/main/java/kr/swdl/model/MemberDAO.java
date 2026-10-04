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
			String memberNumber,
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
			PreparedStatement pstmt=conn.prepareStatement(Query.MEMBER_LOGIN);
			pstmt.setString(1, memberNumber);
			pstmt.setString(2, memberId);
			pstmt.setString(3, memberPw);
			pstmt.setString(4, nickname);
			pstmt.setString(5, phone);
			pstmt.setString(6, email);
			pstmt.setString(7, emailDomain);
			pstmt.setString(8, documentNumber);
			pstmt.setString(9, companyName);
			pstmt.setString(10, companyNumber);
			pstmt.setString(11, businessType);
			pstmt.setString(12, memberName);
			pstmt.setString(13, city);
			pstmt.setString(14, address1);
			pstmt.setString(15, address2);
			result=pstmt.executeUpdate()==1;
			pstmt.close();
		} catch (SQLException e) {			
			e.printStackTrace();
		}		
		return result;
	}
}
