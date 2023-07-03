package kr.co.book.mypage.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.book.mypage.dto.BookSearchDTO;
import kr.co.book.mypage.dto.LibraryDTO;
import kr.co.book.mypage.dto.NaverResultDTO;
import kr.co.book.mypage.service.LibraryService;

@Controller
public class LibraryController {

	@Autowired
	LibraryService libraryService;

	Logger logger = LoggerFactory.getLogger(getClass());


	@RequestMapping("/library{type}List.get")
	public String libraryPageList(HttpSession session,@PathVariable String type) {
		session.setAttribute("loginIdx", "1");
		session.setAttribute("loginNickname", "명아");
		return "/Library/library"+type+"List";
	}
	
	
	@RequestMapping("/libary{type}List.ajax") 
	@ResponseBody
	public HashMap<String, Object> LibaryListAjax(@PathVariable String type,@RequestParam String page,@RequestParam String searchText,HttpSession session) {
		logger.info("type : "+type);
		logger.info("searchText : "+searchText);
		String member_idx = (String) session.getAttribute("loginIdx"); 
		HashMap<String, Object> books = libraryService.libraryList(member_idx,page,type,searchText);
		return books; 
	}
	 
	 
	@RequestMapping("/{type}Detail.go")
	public String libraryDetail(@PathVariable String type,@RequestParam String library_idx, Model model) {
		LibraryDTO book = libraryService.detail(library_idx);
		model.addAttribute("book", book);
		return "/Library/"+type+"Detail";
	}
	

	@RequestMapping("/bookSelectPop.go")
	public String bookListPop() {
		return "/Library/bookSelectPop";
	}
	
	

	@RequestMapping("/libraryWrite.go")
	public String libraryWriteGo(@RequestParam HashMap<String, String> bookInfo, Model model,HttpSession session) {
		
		String member_idx = (String) session.getAttribute("loginIdx");
		bookInfo.put("member_idx", member_idx);
		logger.info("선택 책 정보 : " + bookInfo);
		int chk = libraryService.bookChk(bookInfo.get("library_isbn"),bookInfo.get("member_idx"));
		logger.info("chk : " + chk);
		if (chk == 0) {
			model.addAttribute("book", bookInfo);
			return "/Library/libraryWrite";
		} else {
			model.addAttribute("msg", "이미 등록된 책 입니다. ");
			return "/Library/bookSelectPop";
		}

	}
	
	@RequestMapping("/libraryWrite.do")
	public String libraryWrite(@RequestParam HashMap<String, String> bookData,HttpSession session) {
		logger.info("session loginIdx "+ session.getAttribute("loginIdx"));
		String member_idx = (String) session.getAttribute("loginIdx");
		bookData.put("member_idx", member_idx);
		// 1. 책이 위시 리스트로 등록되어 있는지 체크
		int wishChk = libraryService.wishChk(bookData.get("library_isbn"),bookData.get("member_idx"));
				
		// 2-1. 위시리스트로 등록 되어 있다면 위시리스트에서 삭제
		if(wishChk==1) {
			libraryService.libraryWishDelete(bookData.get("library_isbn"),bookData.get("member_idx"));
		}
		logger.info("작성 책 정보 : " + bookData);
		// 3. 위시리스트에 없다면 등록된 책인지 확인 
		libraryService.write(bookData);
		return "/Library/libraryDone";
	}
		
	@RequestMapping("/libraryUpdate.go")
	public String libraryUpdateGo(@RequestParam String library_idx, Model model) {
		LibraryDTO book = libraryService.detail(library_idx);
		model.addAttribute("book", book);
		return "/Library/libraryUpdate";
	}

	@RequestMapping("/libraryUpdate.do")
	public String libraryUpdate(@RequestParam HashMap<String, String> updateData, Model model) {
		logger.info("update data : " + updateData);
		libraryService.update(updateData);
		LibraryDTO book = libraryService.detail(updateData.get("library_idx"));
		model.addAttribute("book", book);
		return "/Library/libraryDetail";
	}

	@RequestMapping("/library.delete")
	public String libraryDelete(@RequestParam String library_idx) {
		libraryService.libraryDelete(library_idx);
		return "redirect:/libraryList.get";
	}
	
	@RequestMapping("wishRegist.ajax")
	@ResponseBody
	public HashMap<String, String> wishRegist(@RequestParam HashMap<String, String> bookInfo,HttpSession session) {
		logger.info("선택 책 정보 : " + bookInfo);
		String member_idx = (String) session.getAttribute("loginIdx");
		bookInfo.put("member_idx", member_idx);
		
		HashMap<String, String> data = new HashMap<String, String>();
		int registChk = libraryService.bookChk(bookInfo.get("library_isbn"),bookInfo.get("member_idx"));
		if(registChk == 1) {
			data.put("msg", "이미 등록된 책 입니다.");
			return data;
		}else {
			int chk = libraryService.wishChk(bookInfo.get("library_isbn"),bookInfo.get("member_idx"));
		
			logger.info("chk : " + chk);
			if (chk == 0) {
				libraryService.wishRegist(bookInfo);
				data.put("msg", "등록이 완료되었습니다. ");
				return data;
			} else {
				data.put("msg", "이미 등록된 책 입니다.");
				return data;
			}
		}
		
	}
	
	@RequestMapping("/deleteLibrary.ajax")
	@ResponseBody
	public HashMap<String, Object> deleteLibrary(@RequestParam(value="delList[]") ArrayList<String> delList,HttpSession session){
		String member_idx = (String) session.getAttribute("loginIdx");
		HashMap<String, Object> map = libraryService.deleteLibrary(delList,member_idx);
		return map; 
	}

	@RequestMapping("/bookSearch.ajax")
	@ResponseBody
	public List<BookSearchDTO> bookSearchList(String text, int start) {
		List<BookSearchDTO> books = null;

		if (text == "") {

		} else {
			// 네이버 검색 API 요청
			String clientId = "o4MJHO8fSzaaQAg5t8If";
			String clientSecret = "Dth4K5OkPp";

			URI uri = UriComponentsBuilder.fromUriString("https://openapi.naver.com").path("/v1/search/book.json")
					.queryParam("query", text).queryParam("display", 10).queryParam("start", start)
					.queryParam("sort", "sim").encode().build().toUri();

			// Spring 요청 제공 클래스
			RequestEntity<Void> req = RequestEntity.get(uri).header("X-Naver-Client-Id", clientId)
					.header("X-Naver-Client-Secret", clientSecret).build();

			// Spring 제공 restTemplate
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<String> resp = restTemplate.exchange(req, String.class);

			// JSON 파싱 (Json 문자열을 객체로 만듦, 문서화)
			ObjectMapper om = new ObjectMapper();
			NaverResultDTO result = null;

			try {
				result = om.readValue(resp.getBody(), NaverResultDTO.class);
				logger.info("result : " + result);
				logger.info("result : " + result.getItems().get(0).getTitle());
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}

			books = result.getItems();
		}

		logger.info("books" + books);

		return books;
	}
}
