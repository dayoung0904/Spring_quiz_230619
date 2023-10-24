package com.quiz.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson07.Entity.CompanyEntity;
import com.quiz.lesson07.bo.CompanyBO;

@RestController
@RequestMapping("/lesson07/quiz01")
public class Lesson07Quiz01RestController {

	@Autowired
	private CompanyBO companyBO;
	
	@GetMapping("/save1")
	public CompanyEntity save01() {

		String name = "넥손";
		String business = "컨텐츠 게임";
		String scale = "대기업";
		int headcount = 3585;
		
		return companyBO.addCompany(name, business, scale, headcount); // JSON
	}
	
	@GetMapping("/save2")
	public CompanyEntity save02() {

		String name = "버블팡";
		String business = "여신 금융업";
		String scale = "대기업";
		int headcount = 6834;
		
		return companyBO.addCompany(name, business, scale, headcount);
	}
	
	@GetMapping("/update")
	public CompanyEntity update() {
		return companyBO.updateEntityScaleHeadcountById(9, "중소기업", 34);
	}
	
	@GetMapping("/delete")
	public String delete() {
		companyBO.deleteCompanyById(9);
		return "수행 완료";
	}
}
