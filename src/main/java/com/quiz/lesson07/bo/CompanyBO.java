package com.quiz.lesson07.bo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson07.Entity.CompanyEntity;
import com.quiz.lesson07.repository.CompanyRepository;

@Service
public class CompanyBO {

	@Autowired
	private CompanyRepository companyRepository;
	
	//input:파라미터들		output:CompanyEntity
	public CompanyEntity addCompany(String name, String business, String scale, int headcount) {
		
//		CompanyEntity company = CompanyEntity.builder()
//				.name(name)
//				.business(business)
//				.scale(scale)
//				.headcount(headcount)
//				.build();
		
		return companyRepository.save(
					CompanyEntity.builder()
					.name(name)
					.business(business)
					.scale(scale)
					.headcount(headcount)
					.build());
	}
	
	// input: 3개 파라미터		output: CompanyEntity
	public CompanyEntity updateEntityScaleHeadcountById(int id, String scale, int headcount) {
		CompanyEntity company = companyRepository.findById(id).orElse(null); // company가 없다면 null로 저장하겠다.
		if(company != null) {
			company = company.toBuilder()
					.scale(scale)
					.headcount(headcount)
					.build();
			
			companyRepository.save(company);
		}
		return company;
	}
	
	// input: id		output: x
	public void deleteCompanyById(int id) {
		Optional<CompanyEntity> companyOptional = companyRepository.findById(id);
		companyOptional.ifPresent(c -> companyRepository.delete(c)); // ifPresent: 존재한다면 Entity를 c로 꺼낼 것이다.
	}
}
