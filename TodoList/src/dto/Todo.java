package dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Todo implements Serializable{ // 직렬화
	private String title;          // 할 일 제목
	private String detail;    	   // 상세 내용
	private boolean complete; 	   // 완료 여부
	private LocalDateTime regDate; // 등록 날짜
	
	// java.time 패키지
	// LocalDateTime : 날짜, 시간을 나타내는 클래스
	// LocalDateTime.now() : 현재 시간 반환
		
	// 날짜와 시간을 원하는 포맷으로 출력하기
	//  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	//  String formattedDateTime = currentDateTime.format(formatter);
}
