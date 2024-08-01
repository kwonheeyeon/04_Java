package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import dto.Member;

public class MemberDaoImpl implements MemberDao{
	public static final String FILE_PATH = "/io_test/membershipReview.dat";
	
	private List<Member> memberList = null;
	
	ObjectInputStream ois = null;
	ObjectOutputStream oos = null;
	
	public MemberDaoImpl() throws FileNotFoundException, IOException, ClassNotFoundException {
		File file = new File(FILE_PATH);
		
		if(file.exists()) {
			try {
				ois = new ObjectInputStream(new FileInputStream(FILE_PATH));
			
				memberList = (List<Member>)ois.readObject();
			}finally {
				if(ois != null) ois.close();
			}
		}else {
			memberList = new ArrayList<Member>();
		}
	}
	
	@Override
	public List<Member> getMemberList() {
		return memberList;
	}
	
	@Override
	public boolean addMember(Member member) throws IOException {
		memberList.add(member);
		
		saveFile();
		
		return true;
	}
	
	public void saveFile() throws IOException {
		try {
			oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
			oos.writeObject(memberList);
		}finally {
			if(oos != null) oos.close();
		}
	}
}
