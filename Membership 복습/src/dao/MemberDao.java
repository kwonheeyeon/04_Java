package dao;

import java.io.IOException;
import java.util.List;

import dto.Member;

public interface MemberDao {

	List<Member> getMemberList();

	boolean addMember(Member member) throws IOException;

}
