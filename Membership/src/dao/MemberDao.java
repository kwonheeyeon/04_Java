package dao;

import java.io.IOException;
import java.util.List;

import dto.Member;

// DAO(Data Access Object)
// - 데이터가 저장된 곳(파일/DB)에 접근하는 역할의 객체
// - 데이저 저장/수정/삭제/조회 가능

public interface MemberDao{ // + 직렬화
	// 인터페이스 메서드는
	// 묵시적(암묵적)으로 public abstract다!!
	
	/**
	 * Dao 객체가 가지고 있는 memberList 반환
	 * @return memberList
	 */
	List<Member> getMemberList();

	/**
	 * 회원 추가
	 * @param member
	 * @return true
	 * @throws IOException
	 */
	boolean addMember(Member member) throws IOException;
	
	/**
	 * 파일 저장
	 * @throws IOException
	 */
	void saveFile() throws IOException;
}
