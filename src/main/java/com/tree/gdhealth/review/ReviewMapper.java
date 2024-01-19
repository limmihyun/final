package com.tree.gdhealth.review;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tree.gdhealth.vo.Review;

@Mapper
public interface ReviewMapper {
	//추가
	int addReview(Review review);
	//수정
	int updateReview(Review review);
	//삭제
	int deleteReview(Review review);
	//리스트
	List<Review> reviewList();
	//상세
	Review reviewOne(int reviewNo);
}

