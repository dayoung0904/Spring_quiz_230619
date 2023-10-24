package com.quiz.lesson06.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson06.domain.Bookmark;
import com.quiz.lesson06.mapper.BookmarkMapper;

@Service
public class BookmarkBO {

	@Autowired
	private BookmarkMapper bookmarkMapper;
	
	public List<Bookmark> getBookmark(){
		return bookmarkMapper.selectBookmark();
	}
	
	public void addBookmark(String name, String url) {
		bookmarkMapper.insertBookmark(name, url);
	}
	
	// input:url 		output:Bookmark
	// Too many result error => 단건으로 리턴하지만 결과는 List로 나왔을 때 = db에서 이미 중복이 있는데 그것을 select한 경우
	public Bookmark getBookmarkByUrl(String url) {
		return bookmarkMapper.selectBookmarkByUrl(url);
	}
	
	public void deleteBookmarkById(int id) {
		bookmarkMapper.deleteBookmarkById(id);
	}
}
