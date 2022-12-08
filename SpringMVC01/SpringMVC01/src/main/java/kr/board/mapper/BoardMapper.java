package kr.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import kr.board.entity.Board;

@Mapper // @Mapper은 mybatis Api를 가지고 사용한다.
public interface BoardMapper {

	public List<Board> getLists(); // 전체리스트
	public void boardInsert(Board vo); // 
	public Board boardContent(int idx);
	public void boardDelete(int idx);
	public void boardUpdate(Board vo);
	
	@Update("update myboard set count=count+1 where idx=#{idx}")
	public void boardCount(int idx);
}
