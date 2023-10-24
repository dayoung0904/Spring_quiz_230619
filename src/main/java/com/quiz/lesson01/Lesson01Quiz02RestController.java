package com.quiz.lesson01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lesson01/quiz02")
@RestController
public class Lesson01Quiz02RestController {

	// List에 Map담아서 출력하기 -> JSON 타입
	// URL : http://localhost:8080/lesson01/quiz02/1
	@RequestMapping("/1")
	public List<Map<String, Object>> quiz02_1(){
		List<Map<String, Object>> list = new ArrayList<>();
		
		Map<String, Object> movie = new HashMap<>();
		movie.put("rate", 15);
		movie.put("director", "봉준호");
		movie.put("time", 131);
		movie.put("title", "기생충");
		list.add(movie);
		
		Map<String, Object> movie2 = new HashMap<>();
		movie2.put("rate", 0);
		movie2.put("director", "로베르토 베니니");
		movie2.put("time", 116);
		movie2.put("title", "인생은 아름다워");
		list.add(movie2);
		
		Map<String, Object> movie3 = new HashMap<>();
		movie3.put("rate", 12);
		movie3.put("director", "크리스토퍼 놀란");
		movie3.put("time", 147);
		movie3.put("title", "인셉션");
		list.add(movie3);
		
		Map<String, Object> movie4 = new HashMap<>();
		movie4.put("rate", 19);
		movie4.put("director", "윤종빈");
		movie4.put("time", 133);
		movie4.put("title", "범죄와의 전쟁 : 나쁜놈들 전성시대");
		list.add(movie4);
		
		Map<String, Object> movie5 = new HashMap<>();
		movie5.put("rate", 15);
		movie5.put("director", "프란시스 로렌스");
		movie5.put("time", 137);
		movie5.put("title", "헝거게임");
		list.add(movie5);
		
		return list;
	}
	
	// List에 Class담아서 출력하기 -> JSON 타입
	@RequestMapping("/2")
	public List<Post> quiz02_2(){
		// @ResponseBody + return String -> HttpMessageConverter	String(html) -> Response Body에 내려감.
		// @ResponseBody + return 객체(List, Map, 클래스) -> HttpMessageConverter		jackson 라이브러리 -> JSON이 Response Body에 내려감 -> API
		List<Post> postList = new ArrayList<>();
		
		Post post = new Post(); // 일반 자바 bean(객체)
		post.setTitle("안녕하세요 가입인사 드립니다.");
		post.setUser("hagulu");
		post.setContent("안녕하세요. 가입했어요. 앞으로 잘 부탁 드립니다. 활동 열심히 하겠습니다.");
		postList.add(post);
		
		Post post2 = new Post();
		post2.setTitle("헐 대박");
		post2.setUser("bada");
		post2.setContent("오늘 목요일이었어... 금요일인줄");
		postList.add(post2);
		
		Post post3 = new Post();
		post3.setTitle("오늘 데이트 한 이야기 해드릴게요.");
		post3.setUser("dulumary");
		post3.setContent("....");
		postList.add(post3);
		
		return postList;
	}
	
	// List에 Class담아서 출력하기 -> JSON 타입 + 상태코드
	@RequestMapping("/3")
	public ResponseEntity<Post> quiz02_3(){
		
		Post post = new Post();
		post.setTitle("안녕하세요 가입인사 드립니다.");
		post.setUser("hagulu");
		post.setContent("안녕하세요. 가입했어요. 앞으로 잘 부탁 드립니다. 활동 열심히 하겠습니다.");
		
		return new ResponseEntity<>(post, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
