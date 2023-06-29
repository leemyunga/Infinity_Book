package kr.co.book.mypage.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.DefaultUriBuilderFactory.EncodingMode;

import kr.co.book.mypage.dao.TrackerDAO;
import kr.co.book.mypage.dto.TrackerDTO;
import reactor.core.publisher.Mono;

@Service
@MapperScan(value = {"kr.co.book.mypage.dao"}) 
public class TrackerService {
	
	@Autowired TrackerDAO TrackerDAO;

	Logger logger = LoggerFactory.getLogger(getClass());
	
	private static final String KEY = "ttbxmfhxmtm0939001";
   
    public ModelAndView trackerBookSearch(String searchType, String searchValue) {
    	
    	String uri = "http://www.aladin.co.kr/ttb/api/ItemSearch.aspx";
    	
    	ModelAndView mav = new ModelAndView("/tracker/trackerSearch");
    	String replaceValue = searchValue.replaceAll("\\s", "");
    	logger.info("replaceValue : "+replaceValue);
    	logger.info("searchType : {} / searchValue : {}",searchType,replaceValue);
    	
    	if(replaceValue == "") {
    		mav.addObject("search",false);
    	}else {    		
    		String MaxResults = "100";
    		String Start = "1";
    		String Cover = "Small";
    		String SearchTarget = "Book";
    		String output = "JS";
    		String Version = "20131101";
    		
    		DefaultUriBuilderFactory fac = new DefaultUriBuilderFactory(uri);
    		fac.setEncodingMode(EncodingMode.VALUES_ONLY);
    		
    		WebClient client = WebClient.builder().uriBuilderFactory(fac).baseUrl(uri).build();
    		
    		Mono<HashMap> mono = client.get()
    				.uri("?ttbkey="+KEY+"&Start="+Start+"&MaxResults="+MaxResults+"&QueryType="+searchType+"&Query="+replaceValue+
    						"&Cover="+Cover+"&SearchTarget="+SearchTarget+"&output="+output+"&Version="+Version)
    				.retrieve().bodyToMono(HashMap.class);
    		
    		Map<String, Object> resp = mono.flux().toStream().findFirst().get();
    		logger.info("resp : "+resp.size());
    		
    		mav.addObject("list", resp);
    		}    		
		return mav;
	}

    //트래커에 완독한 책 추가
	public boolean trackerAddReadBook(HashMap<String, Object> params) {
		logger.info("params : "+params);
		boolean success = false;
		
		String isbn = (String) params.get("isbn");
		
		//BOOK 테이블에 책 정보가 있는지 확인
		int count = TrackerDAO.bookInfoChk(isbn);
		logger.info("count : "+count);
		
		//책 정보가 저장되어 있을 경우
		if(count > 0) {
			if(saveTracker(params) == 1) {
				success = true;
			}
		}else { //책 정보가 없을 경우
			//api로 책정보 검색해서 가져와서 book에 저장 후 트래커에 저장
			int row = saveBookInfo(params);
			
			if(row == 1) {
				if(saveTracker(params) == 1) {
					logger.info("saveTracker : "+row);
					success = true;
				}   
			}
    					
		}		
		return success;
	}
	
	//책 정보 저장
	public int saveBookInfo(HashMap<String, Object> params) {
		int row = 0;
		
		String uri = "http://www.aladin.co.kr/ttb/api/ItemLookUp.aspx";			
		String output = "JS";
		String Version = "20131101";
		
		DefaultUriBuilderFactory fac = new DefaultUriBuilderFactory(uri);
		fac.setEncodingMode(EncodingMode.VALUES_ONLY);
		
		WebClient client = WebClient.builder().uriBuilderFactory(fac).baseUrl(uri).build();

		Mono<HashMap> mono = client.get()
				.uri("?ttbkey="+KEY+"&itemIdType="+"ISBN"+"&ItemId="+params.get("isbn")+"&output="+output+"&Version="+Version)
				.retrieve().bodyToMono(HashMap.class);
		
		//받아온 응답
		Map<String, Object> resp = mono.flux().toStream().findFirst().get();
		logger.info("resp : "+resp);

		List<Map<String, Object>> bookInfo = (List<Map<String, Object>>) resp.get("item");
		logger.info("bookInfo : "+bookInfo);
		
		TrackerDTO dto = new TrackerDTO();
		
		if (bookInfo != null) {
		    for (Map<String, Object> detail : bookInfo) {
		    	dto.setIsbn((String) detail.get("isbn13"));
		    	dto.setTitle((String) detail.get("title"));
		    	dto.setCover((String) detail.get("cover"));
		    	dto.setAuthor((String) detail.get("author"));
		    	dto.setPublisher((String) detail.get("publisher"));
		    	dto.setDescription((String) detail.get("description"));
		    	dto.setPubdate((String) detail.get("pubDate"));    
		    	logger.info("bookInfo getAuthor : "+dto.getAuthor()+dto.getTitle()+dto.getCover()+dto.getAuthor()+dto.getPublisher()+dto.getDescription()+dto.getPubdate());
		    	
		    	Map<String, Object> subInfo = (Map<String, Object>) detail.get("subInfo");

		    	dto.setTotalPage((int) subInfo.get("itemPage"));
		    	logger.info("bookInfo getTotalPage : "+dto.getTotalPage());
		    }
		    
		    dto.setLoginIdx((int) params.get("loginIdx"));
		    dto.setJsp(String.valueOf(params.get("jsp")));
		    
		    row = TrackerDAO.saveBook(dto);
		    logger.info("row : "+row);
		    		    
		}    				
		return row;
	}
	
	//트래커에 저장 
	public int saveTracker(HashMap<String, Object> params) {
		logger.info("saveTracker");
		int row = TrackerDAO.saveTracker(params);
		logger.info("saveTracker row : "+row);		
		return row;
	}

	//총 페이지 수 가져오기
	public int getTotalPage(HashMap<String, Object> params) {
		int totalPage = 0;
		String isbn = String.valueOf(params.get("isbn"));
		
		if(TrackerDAO.bookInfoChk(isbn) == 1) {
			totalPage = TrackerDAO.getTotalPage(isbn);
		}else {
			int row = saveBookInfo(params);
			if(row == 1) {
				totalPage = TrackerDAO.getTotalPage(isbn);
			}
		}		
		return totalPage;
	}
    

}
