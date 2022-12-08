package kr.board.entity;

import lombok.Data;

// Lombok api는 getter, setter, toStrinig등의 메소드의 작성 코드를 줄여주는 라이브러리이다.
@Data  // @Data는 Lombok이 있어야 생성된다. getter, setter자동생성 어노테이션
public class Board {

	private int idx; // 번호
	private String title; // 제목
	private String content; // 내용
	private String writer; // 작성자
	private String indate; // 작성일
	private int count; // 조회수
	
	
	
}
