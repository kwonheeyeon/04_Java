package service;

import java.io.IOException;
import java.util.List;

import dto.Member;

public interface MemberService {

	boolean addMember(String name, String phone) throws IOException;

	List<Member> getMemberList();

}
