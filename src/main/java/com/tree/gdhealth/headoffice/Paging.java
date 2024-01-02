package com.tree.gdhealth.headoffice;

import lombok.Data;

@Data
public class Paging {

	// 현재 페이지 번호
	private int num;

	// 직원 수
	private int cnt;

	// 한 페이지에 출력할 게시물 갯수
	private int postNum = 8;

	// 마지막 페이징번호
	private int lastPage;

	// 출력할 게시물
	private int displayPost;

	// 한번에 표시할 페이징 번호의 갯수
	private int pageNumCnt = 10;

	// 표시되는 페이지 번호 중 마지막 번호
	private int endPageNum;

	// 표시되는 페이지 번호 중 첫번째 번호
	private int startPageNum;

	// 다음/이전 표시 여부
	private boolean prev;
	private boolean next;

}
