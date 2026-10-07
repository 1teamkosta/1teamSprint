package kr.swdl.model;

public class DocumentVO {
	private String documentNumber;
	private String companyName;
	private String companyNumber;
	private String businessType;
	private String memberName;
	private String city;
	private String address1;
	private String address2;
	
	public DocumentVO(String documentNumber, String companyName, String companyNumber, String businessType,
			String memberName, String city, String address1, String address2) {
		setDocumentNumber(documentNumber);
		setCompanyName(companyName);
		setCompanyNumber(companyNumber);
		setBusinessType(businessType);
		setMemberName(memberName);
		setCity(city);
		setAddress1(address1);
		setAddress2(address2);
	}
	
	public String getDocumentNumber() {
		return documentNumber;
	}
	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyNumber() {
		return companyNumber;
	}
	public void setCompanyNumber(String companyNumber) {
		this.companyNumber = companyNumber;
	}
	public String getBusinessType() {
		return businessType;
	}
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	@Override
	public String toString() {
		return "DocumentVO [documentNumber=" + documentNumber + ", companyName=" + companyName + ", companyNumber="
				+ companyNumber + ", businessType=" + businessType + ", memberName=" + memberName + ", city=" + city
				+ ", address1=" + address1 + ", address2=" + address2 + "]";
	}
	
	
	
	

}
