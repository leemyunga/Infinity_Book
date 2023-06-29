package kr.co.book.alarm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.book.alarm.service.AlarmService;
import lombok.RequiredArgsConstructor;

@Controller
public class AlarmController {

	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired AlarmService service;
	
	@RequestMapping(value="/alarm.go")
	public String alarm() {
		logger.info("alarm으로 이동");
		return "alarm/alarm_test";
	}
	

	@RequestMapping(value="/alarmCheck.go")
	public String alarmCheck() {
		logger.info("alarm으로 이동");
		return "alarm/alarm";
	}

//	@PostMapping(value = "/reply.ajax")
//	public 
	

}
