package service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import dao.MemberDao;
import dao.MemberDaoImpl;
import dto.Member;

public class MemberServiceImpl implements MemberService{
	private MemberDao dao = null;
	
	public MemberServiceImpl() throws FileNotFoundException, ClassNotFoundException, IOException {
		dao = new MemberDaoImpl();
	}
	
	@Override
	public boolean addMember(String name, String phone) throws IOException {
		List<Member> memberList = dao.getMemberList();
		
		for(Member member : memberList) {
			if(phone.equals(member.getPhone())) {
				return false;
			}
		}
		
		Member member = new Member(name, phone, 0, Member.COMMON);
		
		boolean result = dao.addMember(member);
		
		return result;
	}
	
	@Override
	public List<Member> getMemberList() {
		return dao.getMemberList();
	}
}
