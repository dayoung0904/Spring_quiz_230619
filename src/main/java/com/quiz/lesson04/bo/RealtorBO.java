package com.quiz.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson04.domain.Realtor;
import com.quiz.lesson04.mapper.RealtorMapper;

@Service
public class RealtorBO {
	
	@Autowired
	private RealtorMapper realtorMapper;
	
	// input: Realtor 객체
	// output: X
	public void addRelator(Realtor realtor) {
		realtorMapper.insertRealtor(realtor);
	}
	
	// input: realtor의 id
	// output: Realtor
	public Realtor getRealtorById(int id) {
		return realtorMapper.selectRealtorById(id);
	}
}
