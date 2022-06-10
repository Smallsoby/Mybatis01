package com.baekhwa.cho.util;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PageInfo {
	private int start;
	private int end;
	private int total;
	
	public static PageInfo getInstance(int pageNo, int rowTotal, int limit) {
		return new PageInfo(pageNo, rowTotal, limit);
	}
	
	private PageInfo(int pageNo, int rowTotal, int limit) {
		total=rowTotal/limit;
		if(rowTotal%limit > 0) total++;
		
		int pageBlock=5;//한번에 보이는 페이지번호 개수
		
		int blockNo=pageNo/pageBlock;
		if(pageNo%pageBlock != 0) blockNo++;
		//1/5,2/5,3/5,4/5,5/5
		// 0 ,0  ,0  , 0 , 1 : 1
		end=pageBlock*blockNo;
		start=end-pageBlock+1;
		
		if(end > total) end=total;
		
	}
}
