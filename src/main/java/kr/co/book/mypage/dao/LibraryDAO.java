package kr.co.book.mypage.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import kr.co.book.mypage.dto.LibraryDTO;

@Mapper
public interface LibraryDAO {
	/*
	 * LIBRARY_IDX,MEMBER_IDX,LIBRARY_ISBN,LIBRARY_TITLE,LIBRARY_COVER,
	 * LIBRARY_AUTHOR,
	 * LIBRARY_PRICE,LIBRARY_PUBLISHER,LIBRARY_DESCRIPTION,LIBRARY_PUBDATE,
	 * LIBRARY_INFO, LIBRARY_USE,LIBRARY_SHARESTATE,LIBRARY_BLIND,LIBRARY_REG_DATE
	 */
	
	ArrayList<LibraryDTO> list();

	void write(HashMap<String, String> bookData);

	int bookChk(String LIBRARY_ISBN);
	
	int wishChk(String LIBRARY_ISBN);

	LibraryDTO detail(String LIBRARY_IDX);

	void libraryDelete(String lIBRARY_IDX);

	void libraryUpdate(HashMap<String, String> updateData);

	ArrayList<LibraryDTO> libraryList(int offset);

	int totalLibraryList();

	

}
