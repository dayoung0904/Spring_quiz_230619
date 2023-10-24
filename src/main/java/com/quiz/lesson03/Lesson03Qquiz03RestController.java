package com.quiz.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.RealEstateBO;

@RestController
public class Lesson03Qquiz03RestController {

	@Autowired
	private RealEstateBO realEstateBO;
	
	// id가 8인 행의 type 을 전세로 바꾸고 price를 70000으로 변경하세요.
	// 요청 URL : http://localhost:8080/lesson03/quiz03/1?id=8&type=전세&price=70000
	@RequestMapping("/lesson03/quiz03/1")
	public String quiz03(
			@RequestParam("id") int id,
			@RequestParam("type") String type,
			@RequestParam("price") int price) {
		
		int rowCount = realEstateBO.updateTypePriceById(id, type, price);
		return "수정 성공: " + rowCount;
	}
}
