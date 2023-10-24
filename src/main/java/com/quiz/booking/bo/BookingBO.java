package com.quiz.booking.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.booking.domain.Booking;
import com.quiz.booking.mapper.BookingMapper;

@Service
public class BookingBO {

	@Autowired
	private BookingMapper bookingMapper;
	
	public List<Booking> getBooking(){
		return bookingMapper.selectBooking();
				
	}
	
	// input:id		output:X
	public void deleteBookingById(int id) {
		bookingMapper.deleteBookingById(id);
	}
	
	public void addBooking(String name, String date, int day, int headcount, String phoneNumber) {
		bookingMapper.insertBooking(name, date, day, headcount, phoneNumber);
	}
	
	// input: name, phoneNumber		output: Booking(null or Booking)
	public Booking getBookingByNamePhone(String name, String phoneNumber) {
		List<Booking> bookingList = bookingMapper.selectBookingByNamePhone(name, phoneNumber);
		// 0 1(최신) => 마지막 인덱스가 가장 최근 내용
		// 리스트가 비어있으면 null이 아닌 [](empty List)
		if(bookingList.isEmpty()) { // 비어있는 경우
			return null; // null return
		}
		
		// 리스트가 비어있지 않으면 마지막 객체 리턴
		return bookingList.get(bookingList.size() - 1); // booking return
	}
}
