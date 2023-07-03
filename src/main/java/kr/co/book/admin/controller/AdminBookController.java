package kr.co.book.admin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminBookController {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@RequestMapping("/adminBook")
	public String adminBook(){
		return "/admin/book";
	}
	
}
