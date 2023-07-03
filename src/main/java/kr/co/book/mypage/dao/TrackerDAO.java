package kr.co.book.mypage.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import kr.co.book.mypage.dto.TrackerDTO;

public interface TrackerDAO {

	int bookInfoChk(String isbn);

	int saveBook(TrackerDTO dto);

	int saveTracker(HashMap<String, Object> params);

	int getTotalPage(String isbn);

	ArrayList<HashMap<String, Object>> getTrackerList(int loginIdx);

	HashMap<String, Object> trackerDetail(int loginIdx, String isbn);

	int trackerUpdateBook(HashMap<String, Object> params);

	void saveEndDate(String loginIdx, String isbn);

	int trackerDeleteBook(String isbn, int loginIdx);

}
