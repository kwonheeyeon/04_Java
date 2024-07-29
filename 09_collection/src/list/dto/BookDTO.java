package list.dto;

public class BookDTO {
	private String title; // 제목
	private String writer; // 저자(글쓴이)
	private int price; // 가격
	
	public BookDTO() {} // 기본 생성자

	// 매개변수 생성자
	public BookDTO(String title, String writer, int price) {
		super();
		this.title = title;
		this.writer = writer;
		this.price = price;
	}

	// getter/setter
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	// 이클립스 toString() 자동완성 : alt + shift + s -> s
	@Override
	public String toString() {
		return "BookDTO [title=" + title + ", writer=" + writer + ", price=" + price + "]";
	}
}
