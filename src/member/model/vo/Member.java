package member.model.vo;

import java.sql.Date;

public class Member implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private String userNo;							//회원 번호
	private String userId;							//회원 아이디
	private String userPwd;						//회원 암호
	private String userNm;							//회원 이름
	private String nickName;						//닉네임
	private java.sql.Date birthday;			//생년월일
	private String gender;							//회원 성별
	private String phone;							//회원 전화번호
	private String email;								//회원 이메일
	private String address;							//회원 주소
	private String country;							//회원 국가
	private java.sql.Date joinDate;			//회원 가입 날짜
	private String userNow;						//회원 상태
	private String userLv; 							//회원등급
	private String etc;									//회원 기타 정보
	private String userLock;						//접근제한
	
	public Member() {}

	public Member(String userNo, String userId, String userPwd, String userNm, String nickName, Date birthday,
			String gender, String phone, String email, String address, String country, Date joinDate, String userNow,
			String userLv, String etc, String userLock) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userNm = userNm;
		this.nickName = nickName;
		this.birthday = birthday;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.country = country;
		this.joinDate = joinDate;
		this.userNow = userNow;
		this.userLv = userLv;
		this.etc = etc;
		this.userLock = userLock;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserNm() {
		return userNm;
	}

	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public java.sql.Date getBirthday() {
		return birthday;
	}

	public void setBirthday(java.sql.Date birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public java.sql.Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(java.sql.Date joinDate) {
		this.joinDate = joinDate;
	}

	public String getUserNow() {
		return userNow;
	}

	public void setUserNow(String userNow) {
		this.userNow = userNow;
	}

	public String getUserLv() {
		return userLv;
	}

	public void setUserLv(String userLv) {
		this.userLv = userLv;
	}

	public String getEtc() {
		return etc;
	}

	public void setEtc(String etc) {
		this.etc = etc;
	}

	public String getUserLock() {
		return userLock;
	}

	public void setUserLock(String userLock) {
		this.userLock = userLock;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Member [userNo=" + userNo + ", userId=" + userId + ", userPwd=" + userPwd + ", userNm=" + userNm
				+ ", nickName=" + nickName + ", birthday=" + birthday + ", gender=" + gender + ", phone=" + phone
				+ ", email=" + email + ", address=" + address + ", country=" + country + ", joinDate=" + joinDate
				+ ", userNow=" + userNow + ", userLv=" + userLv + ", etc=" + etc + ", userLock=" + userLock + "]";
	}

}

