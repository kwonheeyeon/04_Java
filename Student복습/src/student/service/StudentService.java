package student.service;

import java.util.Random;

import student.dto.StudentDTO;

public class StudentService {
	private StudentDTO[] students = new StudentDTO[5];
	
	public StudentService(){
	
		students[0] = new StudentDTO("짱구", "24001", '남');
		students[1] = new StudentDTO("유리", "24002", '여');
		students[2] = new StudentDTO("훈이", "24003", '남');
	
		Random random = new Random();
	
		for(StudentDTO std : students) {
			if(std == null) break;
		
			std.setHtml(random.nextInt(101));
			std.setCss(random.nextInt(101));
			std.setJs(random.nextInt(101));
			std.setJava(random.nextInt(101));
		}
	}
	
	public boolean addStudent(StudentDTO std) {
		for(int i=0; i<students.length; i++) {
			if(students[i] == null) {
				students[i] = std;
				return true;
			}
		}
		
		return false;
	}
	
	public StudentDTO[] selectAll() {
		return students;
	}
	
	public StudentDTO selectIndex(int index) {
		if(index < 0 || index >= students.length) {
			return null;
		}
		
		for(int i=0; i<students.length; i++) {
			if(students[i] == null) return null;
			
			if(i == index) return students[i];
		}
		
		return null;
	}
	
	public StudentDTO selectTargetName(String targetName) {
		for(StudentDTO std : students) {
			if(std != null && std.getName().equals(targetName)) {
				return std;
			}
		}
		
		return null;
	}
}
