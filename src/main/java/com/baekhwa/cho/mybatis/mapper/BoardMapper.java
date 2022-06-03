package com.baekhwa.cho.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.baekhwa.cho.domain.dto.BoardDTO;

@Mapper
public interface BoardMapper {

	@Select("select * from jpa_board where no>0 order by no desc")
	List<BoardDTO> findAll();

}
