package com.mysite.board;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mysite.DataNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {

	private final BoardRepository boardRepository;
	
	public Board getBoard(Integer id) {
		
		Optional<Board> ob = this.boardRepository.findById(id);
		if(ob.isPresent()) {
			return ob.get();
		}else {
			throw new DataNotFoundException("요청한 파일을 찾을 수 없습니다.");
		}
	}
	
	
}
