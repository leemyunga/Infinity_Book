package kr.co.book.admin.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.co.book.admin.dto.AdminInquiryDTO;
import kr.co.book.admin.service.AdminInquiryService;

@Controller
public class AdminInquiryController {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired AdminInquiryService service;
	
	// 문의 상세보기
	@RequestMapping(value = "/inquirydetail.go")
	public ModelAndView inquirydetail(@RequestParam String inquiry_idx) {
		
		ModelAndView mav = new ModelAndView("/inquiry/inquirylist");
		AdminInquiryDTO dto =  service.inquirydetail(inquiry_idx);
		if (dto != null) {
			mav.addObject("inquiry", dto);
			mav.setViewName("/inquiry/inquirydetail");
		}
		
		return mav;
	}
	
	// 문의 답변 이동
	@RequestMapping(value = "/inquiryreplywrite.go")
	public String inquiryreplywriteForm(@RequestParam String inquiry_idx,@RequestParam String code_idx,Model model) {
		logger.info(inquiry_idx+"/"+code_idx);
		model.addAttribute("inquiry_idx", inquiry_idx);
		model.addAttribute("code_idx", code_idx);
		return "/inquiry/inquiryreplywrite";
	}
	
	// 문의 답변 하기
	@RequestMapping(value = "/inquiryreplywrite.do")
	public String inquiryreplywrite(@RequestParam HashMap<String, Object> params, HttpSession session) {
		
		String loginIdx = session.getAttribute("loginIdx").toString();
		params.put("member_idx", loginIdx);
		service.inquiryreplywrite(params);
		
		return "/inquiry/inquirylist";
	}	
	
	// 문의 리스트
	@RequestMapping(value = "/inquirylist.go")
	public String myinquirylistForm() {		
		
		return "/inquiry/inquirylist";
	}
	
	// 문의 리스트 불러오기
	@RequestMapping(value = "/inquirylist.ajax")
	@ResponseBody
	public HashMap<String, Object> myinquirylist(@RequestParam HashMap<String,Object> params) {
		logger.info("{}",params);

		HashMap<String, Object> inquiry = service.inquiryList(params);
		
		return inquiry;
	}

}
