package com.quiz.lesson02.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.quiz.lesson02.domain.Store;

@Repository
public interface StoreMapper {

	// input(BO-Service 요청): X
	// output(BO-Service 결과 돌려줌): List<UsedGoods>
	public List<Store> selectStoreList();
}
