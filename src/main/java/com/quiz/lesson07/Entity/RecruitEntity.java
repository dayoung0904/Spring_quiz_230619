package com.quiz.lesson07.Entity;

import java.time.LocalDate;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder(toBuilder = true) // setter 대용, tobuilder = true 수정 허용
@Entity
@Table(name="recruit")
public class RecruitEntity {
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY) // pk에게 해주는 어노테이션 2개
	private int id;
	
	@Column(name = "companyId")
	private int companyId;
	
	private String position;
	
	private String responsibilities;
	
	private String qualification;
	
	private String type;
	
	private String region;
	
	private int salary;
	
	private LocalDate deadline; // 시분초 없음
	
	@UpdateTimestamp // 시간을 넣지 않아도 현재 시간으로 자동으로 들어감 = NOW();
	@Column(name = "createdAt" , updatable = false) // updateable = false는 업데이트시 변경되지 않도록 설정
	private ZonedDateTime createdAt;
	
	@UpdateTimestamp
	@Column(name = "updatedAt")
	private ZonedDateTime updatedAt;
}
