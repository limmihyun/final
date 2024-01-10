package com.tree.gdhealth.question;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tree.gdhealth.vo.Question;

@Transactional
@Service
public class QuestionService {
	@Autowired QuestionMapper questionMapper;
	
	//문의 리스트
	public List<Question> questionList(){
		
		List<Question> resultQuestionList = questionMapper.questionList();
		return resultQuestionList;
	}
	
	//문의 상세
	public Question questionOne(int questionNo) {
		
		Question resultQuestionOne = questionMapper.questionOne(questionNo);
		
		return resultQuestionOne;
	}
	//문의 추가
	public int addQuestion(Question question) {
		int row = questionMapper.addQuestion(question);
		return row;
	}
	//문의 수정
	public int updateQuestion(Question question) {
		System.out.println("Update: " + question);
		int row = questionMapper.updateQuestion(question);
		return row;
	}
	//문의 삭제
	public int deleteQuestion(Question question) {
		int row = questionMapper.deleteQuestion(question);
		return row;
	}
}
