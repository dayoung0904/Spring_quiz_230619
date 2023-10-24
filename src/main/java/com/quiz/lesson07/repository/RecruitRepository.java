package com.quiz.lesson07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson07.Entity.RecruitEntity;

@Repository
public interface RecruitRepository extends JpaRepository<RecruitEntity, Integer>{
	// Spring Data JPA
	// findById
	
	// JPQL => Entity 조회 요청
	public List<RecruitEntity> findByCompanyId(int companyId);
	public List<RecruitEntity> findByPositionAndType(String position, String type);
	public List<RecruitEntity> findByTypeOrSalaryGreaterThanEqual(String type, int salary);
	public List<RecruitEntity> findTop3ByTypeOrderBySalaryDesc(String type);
	public List<RecruitEntity> findByRegionAndSalaryBetween(String region, int start, int end);
	
	// NativeQuery 조회 => DB에 직접 조회
	@Query(value = "select * from `recruit` "
			+ "where `deadline`> :deadline "
			+ "and `salary` >= :salary "
			+ "and `type` = :type "
			+ "order by salary desc", nativeQuery = true)
	public List<RecruitEntity> findByDeadlineAfterAndSalaryGreaterThanEqualAndTypeOrderBySalaryDesc(
			@Param("deadline") String deadline, // 쿼리문 사용을 위해 Param 어노테이션 필수
			@Param("salary") int salary, 
			@Param("type") String type);
	
}
