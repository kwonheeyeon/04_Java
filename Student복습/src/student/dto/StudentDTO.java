package student.dto;

public class StudentDTO {
	private String name;
	private String studentNumber;
	private char gender;
	private int html;
	private int css;
	private int js;
	private int java;
	
	
	public StudentDTO(String name, String studentNumber, char gender) {
		this.name = name;
		this.studentNumber = studentNumber;
		this.gender = gender;
	}

	
	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getHtml() {
		return html;
	}

	public void setHtml(int html) {
		this.html = html;
	}

	public int getCss() {
		return css;
	}

	public void setCss(int css) {
		this.css = css;
	}

	public int getJs() {
		return js;
	}

	public void setJs(int js) {
		this.js = js;
	}

	public int getJava() {
		return java;
	}

	public void setJava(int java) {
		this.java = java;
	}
	
	public String toString() {
		return String.format("%s / %c / %s \nHTML : %d / CSS : %d / JS : %d / Java : %d\n",
							 studentNumber, gender, name, html, css, js, java);
	}
}
