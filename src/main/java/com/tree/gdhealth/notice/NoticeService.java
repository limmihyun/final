package com.tree.gdhealth.notice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tree.gdhealth.vo.Notice;

@Service
@Transactional
public class NoticeService {
   @Autowired
   private NoticeMapper noticeMapper;
     
   // 공지추가
   public int addNotice(Notice notice) {
      int row = noticeMapper.addNotice(notice);
      return row;
   }
   
   // 공지수정
   public int updateNotice(Notice notice) {
      int row = noticeMapper.updateNotice(notice);
      return row;
   }
   
   // 공지삭제
   public int deleteNotice(Notice notice) {
      int row = noticeMapper.deleteNotice(notice);
      System.out.println(row + "<-- row");
      return row;
   }
   
   // 공지상세
   public Notice noticeOne(int noticeNo) {
      Notice resultNoticeOne = noticeMapper.noticeOne(noticeNo);
      return resultNoticeOne;
   }
   
   // 공지 리스트
   public List<Notice> noticeList(int currentPage){
      int rowPerPage = 10;
      int beginRow = (currentPage -1) * rowPerPage;
      
      Map<String, Object> paramMap = new HashMap<>();
      
      paramMap.put("beginRow", beginRow);
      paramMap.put("rowPerPage", rowPerPage);
      
      List <Notice> resultNoticeList = noticeMapper.noticeList(paramMap);
      return resultNoticeList;
   }
   
}