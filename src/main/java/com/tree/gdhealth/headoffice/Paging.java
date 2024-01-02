package com.tree.gdhealth.headoffice;


public class Paging {
	
	// 한 페이지에 출력할 게시물 갯수
	private int postNum = 8;
	
	// 한번에 표시할 페이징 번호의 갯수
	private int pageNumCnt = 10;

	// 현재 페이지 번호
	private int num;

	// 직원 수
	private int cnt;

	// 마지막 페이징번호
	private int lastPage;

	// 출력할 게시물
	private int displayPost;

	// 표시되는 페이지 번호 중 마지막 번호
	private int endPageNum;

	// 표시되는 페이지 번호 중 첫번째 번호
	private int startPageNum;

	// 다음/이전 표시 여부
	private boolean prev;
	private boolean next;
	
	public void setNum(int num) {
		this.num = num;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt; 
		calculation();
	}

	public int getCnt() {
		return cnt;
	}

	public int getPostNum() {
		return postNum;
	}

	public int getLastPage() {
		return lastPage;
	}

	public int getDisplayPost() {
		return displayPost;
	}

	public int getPageNumCnt() {
		return pageNumCnt;
	}

	public int getEndPageNum() {
		return endPageNum;
	}

	public int getStartPageNum() {
		return startPageNum;
	}

	public boolean getPrev() {
		return prev;
	} 

	public boolean getNext() {
		return next;
	}
	
	private void calculation() {
		
		 lastPage = (int) Math.ceil((double)cnt/postNum);
		
		 // 마지막 번호
		 endPageNum = (int)(Math.ceil((double)num / (double)pageNumCnt) * pageNumCnt);
		 
		 // 시작 번호
		 startPageNum = endPageNum - pageNumCnt + 1;
		 
		 // 마지막 번호 재계산
		 int endPageNum_tmp = (int)(Math.ceil((double)cnt / (double)postNum));
		 
		 if(endPageNum > endPageNum_tmp) {
		  endPageNum = endPageNum_tmp;
		 }
		 		 
		 prev = startPageNum == 1 ? false : true;
		 next = endPageNum * postNum >= cnt ? false : true; 
		 
		 displayPost = (num - 1) * postNum;
		 
	}

}
