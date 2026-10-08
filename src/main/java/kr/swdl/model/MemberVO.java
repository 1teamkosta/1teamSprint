package kr.swdl.model;

import java.util.List;

public class MemberVO {

	private String memberNumber;
	private String memberId;
	private String memberPw;
	private String nicname;
	private String phone;
	private String email;
	private String emailDomain;
	private List<DocumentVO> signupFile;


	public MemberVO(String memberNumber, String memberId, String memberPw, String nicname, String phone, String email,
			String emailDomain) {
		this(memberNumber,memberId,memberPw,nicname,phone,email,emailDomain,null);
	}
	
	public MemberVO(String memberNumber, String memberId, String memberPw, String nickname, String phone, String email,
			String emailDomain, List<DocumentVO> signupFile) {
		setMemberNumber(memberNumber);
		setMemberId(memberId);
		setMemberPw(memberPw);
		setNicname(nickname);
		setPhone(phone);
		setEmail(email);
		setEmailDomain(emailDomain);
		setSignupFile(signupFile);
		}
	
	public String getMemberNumber() {
		return memberNumber;
	}
	public void setMemberNumber(String memberNumber) {
		this.memberNumber = memberNumber;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getNicname() {
		return nicname;
	}
	public void setNicname(String nicname) {
		this.nicname = nicname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmailDomain() {
		return emailDomain;
	}
	public void setEmailDomain(String emailDomain) {
		this.emailDomain = emailDomain;
	}
	public List<DocumentVO> getSignupFile() {
		return signupFile;
	}
	public void setSignupFile(List<DocumentVO> signupFile) {
		this.signupFile = signupFile;
	}
	@Override
	public String toString() {
		return "MemberVO [memberNumber=" + memberNumber + ", memberId=" + memberId + ", memberPw=" + memberPw
				+ ", nicname=" + nicname + ", phone=" + phone + ", email=" + email + ", emailDomain=" + emailDomain
				+ ", signupFile=" + signupFile + "]";
	}

	
	
}
