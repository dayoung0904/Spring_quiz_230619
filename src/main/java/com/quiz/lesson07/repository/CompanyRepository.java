package com.quiz.lesson07.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiz.lesson07.Entity.CompanyEntity;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity, Integer>{ // <넣는 객체, id값을 제네릭타입으로>
	// JpaRepostitory: Stpring Data JPA
	
	// save(엔티티객체) - insert, update(id가 채워져있는 경우)
	// findById - id로 조회
	// delete(엔티티객체) - 객체 삭제
}
