package kr.co.book.member.dto;

public class MemberDTO {

	private int member_idx;
	private String member_email;
	private String member_pw;
	private String member_nickname;	
	private String address;
	private int code_idx;
	
	public int getMember_idx() {
		return member_idx;
	}
	public void setMember_idx(int member_idx) {
		this.member_idx = member_idx;
	}
	public String getMember_email() {
		return member_email;
	}
	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}
	public String getMember_pw() {
		return member_pw;
	}
	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}
	public String getMember_nickname() {
		return member_nickname;
	}
	public void setMember_nickname(String member_nickname) {
		this.member_nickname = member_nickname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getCode_idx() {
		return code_idx;
	}
	public void setCode_idx(int code_idx) {
		this.code_idx = code_idx;
	}
	
	
	
	
}
