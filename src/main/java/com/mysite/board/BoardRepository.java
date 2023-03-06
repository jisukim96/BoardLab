package com.mysite.board;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface BoardRepository extends JpaRepository<Board, Integer> {

	//select * from question where subject = ? -> 검색 결과가 1개일 때 처리
	Board findBySubject(String subject);
	
	//select * from question where content = ? -> 검색 결과가 1개일 때 ..
	Board findByContent(String content);
	
	//select * from question where subject like '%sbb%'
	List<Board> findBySubjectLike(String subject);
	
	//content 컬럼 조건으로 검색 
	// select * from question where content like '%내용%'
	List<Board> findByContentLike(String content);
	
	// select * from question where subject like '%sbb%' or content like '%내용%'
	List<Board> findBySubjectOrContentLike(String subject , String content);
	
	// 조건을 사용해서 출력 후 정렬하여 출력 : Order By
	//select * from question order by createDate asc	: 오름차순 정렬
	//select * from question order by createDate desc	: 내림차순 정렬
	List<Board> findBySubjectLikeOrderByCreateDateAsc(String subject);
	List<Board> findBySubjectLikeOrderByCreateDateDesc(String subject);
	
	//모든 레코드를 정렬해서 출력
	// select * from question order by create_date asc
	// select * from question order by create_date desc
	List<Board> findAllByOrderByCreateDateAsc();
	List<Board> findAllByOrderByCreateDateDesc();
}
