package member.model.dao;

import static common.JDBCTemp.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import member.model.vo.Member;

public class MemberDao {
	public MemberDao() {}
	
	//로그인 처리용 메소드 : select
	public Member selectLogin(Connection conn, String userId, String userPwd) {
		Member m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_user "
				+ "where user_id = ? and user_pwd = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				m = new Member();
				
				m.setUserNo(rset.getString("user_no"));
				m.setUserId(rset.getString("user_id"));
				m.setUserPwd(rset.getString("user_pwd"));
				m.setUserNm(rset.getString("user_nm"));
				m.setNickName(rset.getString("nick_name"));
				m.setBirthday(rset.getDate("birthday"));
				m.setGender(rset.getString("gender"));
				m.setPhone(rset.getString("phone"));
				m.setEmail(rset.getString("email"));
				m.setAddress(rset.getString("address"));
				m.setCountry(rset.getString("country"));
				m.setJoinDate(rset.getDate("join_date"));
				m.setUserNow(rset.getString("user_now"));
				m.setUserLv(rset.getString("user_lv"));
				m.setEtc(rset.getString("etc"));
				m.setUserLock(rset.getString("user_lock"));
											
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return m;
	}
	
	//회원 가입 처리용 메소드 : insert
	public int insertMember(Connection conn, Member member) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into tb_user "
				+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getUserId());
			pstmt.setString(2, member.getUserPwd());
			pstmt.setString(3, member.getUserNm());
			pstmt.setString(4, member.getNickName());
			pstmt.setDate(5, member.getBirthday());
			pstmt.setString(6, member.getGender());
			pstmt.setString(7, member.getPhone());
			pstmt.setString(8, member.getEmail());
			pstmt.setString(9, member.getAddress());
			pstmt.setString(10, member.getCountry());			
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	//회원 탈퇴 처리용 메소드 : delete
	public int deleteMember(Connection conn, String userId) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "delete from tb_user where user_id = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);

			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	//회원 정보 보기 처리용 메소드 : select
	public Member selectMember(Connection conn, String userId) {
		Member m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_user where user_id = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				m = new Member();

				m.setUserId(rset.getString("user_id"));
				m.setUserPwd(rset.getString("user_pwd"));
				m.setUserNm(rset.getString("user_nm"));
				m.setNickName(rset.getString("nick_name"));
				m.setBirthday(rset.getDate("birthday"));
				m.setGender(rset.getString("gender"));
				m.setPhone(rset.getString("phone"));
				m.setEmail(rset.getString("email"));
				m.setAddress(rset.getString("address"));
				m.setCountry(rset.getString("country"));
				m.setJoinDate(rset.getDate("join_date"));
				m.setUserNow(rset.getString("user_now"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return m;
	}
	
	//회원 정보 수정 처리용 메소드 : update
	public int updateMember(Connection conn, Member member) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update tb_user set user_pwd = ?, phone = ?, where user_id = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getUserPwd());
			pstmt.setString(2, member.getPhone());
			pstmt.setString(3, member.getUserId());

			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	//관리자용 회원 전체 조회 처리용 메소드 : select
	public ArrayList<Member> selectList(Connection conn){
		ArrayList<Member> list = new ArrayList<Member>();
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select * from tb_user";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			while(rset.next()) {
				Member m = new Member();

				m.setUserNo(rset.getString("user_no"));
				m.setUserId(rset.getString("user_id"));
				m.setUserPwd(rset.getString("user_pwd"));
				m.setUserNm(rset.getString("user_nm"));
				m.setNickName(rset.getString("nick_name"));
				m.setBirthday(rset.getDate("birthday"));
				m.setGender(rset.getString("gender"));
				m.setPhone(rset.getString("phone"));
				m.setEmail(rset.getString("email"));
				m.setAddress(rset.getString("address"));
				m.setCountry(rset.getString("country"));
				m.setJoinDate(rset.getDate("join_date"));
				m.setUserNow(rset.getString("user_now"));
				m.setUserLv(rset.getString("user_lv"));
				m.setEtc(rset.getString("etc"));
				m.setUserLock(rset.getString("user_lock"));
																			
				list.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		
		return list;
	}

	public int selectCheckId(Connection conn, String userid) {
		int idcount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = "select count(user_id) from tb_user where user_id = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userid);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				idcount = rset.getInt(1);
				System.out.println("idcount : " + idcount);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}		
		
		return idcount;
	}

	public int updateUserLock(Connection conn, String userid, String userlock) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "update tb_user set user_lock = ? where user_id = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userlock);
			pstmt.setString(2, userid);						

			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
}





