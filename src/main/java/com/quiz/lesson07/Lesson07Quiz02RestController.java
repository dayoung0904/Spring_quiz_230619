package com.quiz.lesson07;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson07.Entity.RecruitEntity;
import com.quiz.lesson07.repository.RecruitRepository;



@RequestMapping("lesson07/quiz02")
@RestController
public class Lesson07Quiz02RestController {

	@Autowired
	private RecruitRepository recruitRepository;
	
	@GetMapping("/1")
	public RecruitEntity quiz02_1(){
		
		// 1) id 기준 조회
		return recruitRepository.findById(8).orElse(null);
	}
	
	@GetMapping("/2")
	public List<RecruitEntity> quiz02_2(
			@RequestParam("companyId") int companyId){
		
		// 2) company id 로 조회
		return recruitRepository.findByCompanyId(companyId);
	}
	
	@GetMapping("/3")
	public List<RecruitEntity> quiz02_3(){
		
		// 3) 여러 컬럼값과 일치하는 데이터 조회 AND
		return recruitRepository.findByPositionAndType("웹 back-end 개발자", "정규직");
	}
	 
	@GetMapping("/4")
	public List<RecruitEntity> quiz02_4(){
		
		// 4) 복합 조건 조회 => 정규직이거나 연봉이 9000 이상인 공고를 조회 => OR + >=
		return recruitRepository.findByTypeOrSalaryGreaterThanEqual("정규직", 9000);
	}
	
	@GetMapping("/5")
	public List<RecruitEntity> quiz02_5(){
		
		// 5) 정렬제한 조건 => 계약직 목록을 연봉기준으로 내림차순 3개 => top3 + order by
		return recruitRepository.findTop3ByTypeOrderBySalaryDesc("계약직");
	}

	@GetMapping("/6")
	public List<RecruitEntity> quiz02_6(){
		
		// 6) 범위 조회 => 지역 조건 + 연봉 범위 조건
		return recruitRepository.findByRegionAndSalaryBetween("성남시 분당구", 7000, 8500);
	}
	
	@GetMapping("/7")
	public List<RecruitEntity> quiz02_7(){
		
		// 7) native query
		return recruitRepository.findByDeadlineAfterAndSalaryGreaterThanEqualAndTypeOrderBySalaryDesc("2026-04-10", 8100, "정규직");
	}

	   
}
