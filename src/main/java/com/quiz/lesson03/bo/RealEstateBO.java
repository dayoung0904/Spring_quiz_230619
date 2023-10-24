package com.quiz.lesson03.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson03.domain.RealEstate;
import com.quiz.lesson03.mapper.RealEstateMapper;

@Service
public class RealEstateBO {

	@Autowired
	private RealEstateMapper realEstateMapper;
	
	// input: id
	// ouput : RealEstate
	public RealEstate getRealEasteByID(int id) {
		return realEstateMapper.selectRealEstateByID(id);
	}
	
	// input: rentPrice
	// output : List<RealEstate>
	public List<RealEstate> getRealEasteListByPrice(int rent_price) {
		return realEstateMapper.selectRealEstateListByPrice(rent_price);
	}
	
	// input: area, price
	// output: List<RealEstate>
	public List<RealEstate> getRealEasteListByAreaPrice(int area, int price){
		return realEstateMapper.selectRealEasteListByAreaPrice(area, price);
	}
	
	// input: RealEstate
	// output : 성공된 행의 개수(int)
	public int addRealEstate(RealEstate realEstate) {
		return realEstateMapper.insertRealEstate(realEstate);
	}
	
	//addRealEstateAsField(realtorId, "썅떼빌리버 오피스텔 814호", 45, "월세", 100000, 120);
	public int addRealEstateAsField(int realtorId, String address, int area, String type, int price, Integer rentPrice) {
		return realEstateMapper.insertRealEstateAsField(realtorId, address, area, type, price, rentPrice);
	}
	
	// input : id, type, price
	// output : int
	public int updateTypePriceById(int id, String type, int price) {
		return realEstateMapper.updateTypePriceById(id, type, price);
	}
	
	public int deleteRealEstateById(int id) {
		return realEstateMapper.deleteRealEstateById(id);
	}
}
