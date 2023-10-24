package com.quiz.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.BookmarkBO;
import com.quiz.lesson06.domain.Bookmark;

@RequestMapping("/lesson06")
@Controller
public class Lesson06Controller {
	@Autowired
	private BookmarkBO bookmarkBO;

	// quiz01
	// 즐겨찾기 추가 화면
	@GetMapping("/quiz01/add-bookmark-view")
	public String addBookmarkView() {
		return "lesson06/addBookmark";
	}
	
	// 즐겨찾기 추가 로직 => AJAX에서 하는 요청
	@PostMapping("/quiz01/add-bookmark")
	@ResponseBody
	public Map<String, Object> addBookmark(
			@RequestParam("name") String name,
			@RequestParam("url") String url) {
		
		// db insert
		bookmarkBO.addBookmark(name, url);
		
		// 응답값 : Json String
//		{
//			   "code":200,
//			   "result":"success"
//		}
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "success");
		
		return result; // JSON String
	}
	
	// 즐겨찾기 목록 화면 페이지
	@GetMapping("/quiz01/get-bookmark-list")
	public String getBookmarkList(Model model) {
		List<Bookmark> bookmarks = bookmarkBO.getBookmark();
		model.addAttribute("bookmarks", bookmarks);
		return "lesson06/getBookmark";
		
	}
	
	// ---- quiz02
	// url 중복 확인 - ajax요청
	@ResponseBody
	@PostMapping("/quiz02/is-duplicated-url")
	public Map<String, Object> isDuplicatedUrl(
			@RequestParam("url") String url){
		
		// db조회 => null or 행
		Bookmark bookmark = bookmarkBO.getBookmarkByUrl(url);
		
		// 응답값
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("is_duplication", false);			
		if(bookmark != null) {
			result.put("is_duplication", true);			
		}
		
		return result;
		
	}
	
	//  --- quiz02 db삭제 => ajax요청
	@ResponseBody
	@DeleteMapping("/quiz02/delete-bookmark")
	public Map<String, Object> deleteBookmark(
			@RequestParam("id") int id){
		
		// db delete
		bookmarkBO.deleteBookmarkById(id);
		
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "성공");
		return result;
	}
}
