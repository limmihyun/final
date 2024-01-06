package com.tree.gdhealth.headoffice;


public class Paging {
	
	// 한번에 표시할 페이징 번호의 갯수
	private int pageNumCnt = 10;
		
	// 한 페이지에 출력할 게시물 갯수
	private int rowPerPage;
	
	// 현재 페이지 번호
	private int currentPage;

	// row 개수
	private int cnt;

	// 마지막 페이징번호
	private int lastPage;

	// 한 페이지에 출력할 회원들 중 첫 번째 회원의 row 값
	private int beginRow;

	// 표시되는 페이지 번호 중 마지막 번호
	private int endPageNum;

	// 표시되는 페이지 번호 중 첫번째 번호
	private int startPageNum;

	// 다음/이전 표시 여부
	private boolean prev;
	private boolean next;
	
	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}
	
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt; 
		calculation();
	}

	public int getCnt() {
		return cnt;
	}

	public int getRowPerPage() {
		return rowPerPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public int getBeginRow() {
		return beginRow;
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
		
		 lastPage = (int) Math.ceil((double)cnt/rowPerPage);
		 if(lastPage == 0) {
			 lastPage = 1;
		 }
		
		 // 마지막 번호
		 endPageNum = (int)(Math.ceil((double) currentPage / (double)pageNumCnt) * pageNumCnt);
		 
		 // 시작 번호
		 startPageNum = endPageNum - pageNumCnt + 1;
		 
		 // 마지막 번호 재계산
		 int endPageNum_tmp = (int)(Math.ceil((double)cnt / (double)rowPerPage));
		 
		 if(endPageNum > endPageNum_tmp) {
		  endPageNum = endPageNum_tmp;
		 }
		 		 
		 prev = startPageNum == 1 ? false : true;
		 next = endPageNum * rowPerPage >= cnt ? false : true; 
		 
		 beginRow = (currentPage - 1) * rowPerPage;
		 
	}

}
