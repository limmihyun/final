package com.tree.gdhealth.question;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tree.gdhealth.vo.Question;

@Mapper
public interface QuestionMapper {
	
	//질문 리스트
	List<Question> questionList();
	
	//질문 상세
	Question questionOne(int questionNo) ;
	
	//본사 확인
	int getBranchLevel(int employeeNo);
	
	//추가
	int addQuestion(Question question);
	
	//수정
	int updateQuestion(Question question);
	
	//삭제
	int deleteQuestion(Question question);
}
   