package com.baekhwa.cho.mybatis.mapper;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;

import com.baekhwa.cho.domain.dto.BoardDTO;
import com.baekhwa.cho.domain.dto.BoardInsertDTO;
import com.baekhwa.cho.domain.dto.BoardListDTO;
import com.baekhwa.cho.domain.dto.BoardUpdateDTO;

@Mapper
public interface BoardMapper {

	@Select("select * from mybatis_board where no>0 order by no desc")
	List<BoardDTO> findAll();

	@Insert("insert into mybatis_board(title,content,writer) "
			+ "values(#{title},#{content},#{writer})")
	int save(BoardInsertDTO dto);

	@Select("select * from mybatis_board where no=#{no}")
	Optional<BoardDTO> findById(int no);

	@Update("update mybatis_board "
			+ "set title=#{title}, content=#{content} "
			+ "where no=#{no}")
	int update(BoardUpdateDTO dto);

	@Delete("delete from mybatis_board where no=#{no}")
	int deleteById(int no);

	@Select("select * from mybatis_board where no>0 order by no desc "
			+ "limit #{offset} , #{limit}")
	List<BoardListDTO> select(@Param("offset") int offset,@Param("limit") int limit);

	@Select("select count(*) from mybatis_board")
	int selectCount();



}
