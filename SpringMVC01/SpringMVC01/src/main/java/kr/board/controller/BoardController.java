package kr.board.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.board.entity.Board;
import kr.board.mapper.BoardMapper;

@Controller
public class BoardController {
	// boardList.do
	@Autowired
	private BoardMapper mapper;
	
	// HandlerMapping
	@RequestMapping("/boardList.do") // Dispatcher servlet으로 부터 /boardList.do로 HandlerMapping되어 찾는다.
	public String boardList(Model model) {
		List<Board> list = mapper.getLists(); // DB에서만든 getLists()메소드 호출하여 list타입으로변수만듬.
		model.addAttribute("list", list); // 객체 바인딩한다.
	
		return "boardList"; // /WEB-INF/views/ view resolver를 통해 해당...jsp 찾는다. -> forward를 한다.(내용 실어보내기)
	}

	@GetMapping("/boardForm.do")
	public String boardForm() {
		
		return "boardForm"; // /WEB-INF/views/boardForm.jsp -> forward한다.
	}
	
	@PostMapping("/boardInsert.do")
	public String boardInsert(Board vo) { // title, content, writer => jsp에서 파라미터 수집(Board)하여 다시 DB로 보내준다.
		mapper.boardInsert(vo); // 등록
		
		return "redirect:/boardList.do";
	}
	
	@GetMapping("/boardContent.do")
	public String boardContent(int idx, Model model) { 
		Board vo = mapper.boardContent(idx);
		// 조회수 증가
		mapper.boardCount(idx);
		
		model.addAttribute("vo", vo); // model에 태워 forward(객체바인딩)한다.
		
		return "boardContent";
	
	}
	
	@GetMapping("/boardDelete.do/{idx}")
	public String boardDelete(@PathVariable("idx") int idx) {
		mapper.boardDelete(idx);
		
		return "redirect:/boardList.do";
	}
	
	@GetMapping("/boardUpdateForm.do/{idx}")
	public String boardUpdateForm(@PathVariable("idx") int idx, Model model) {
		Board vo = mapper.boardContent(idx); // idx(번호)를 가지고 모든 정보를 DB에서 가져옴
		model.addAttribute("vo", vo);
		
		return "boardUpdate";
	}
	
	@PostMapping("/boardUpdate.do")
	public String boardUpdate(Board vo) { // idx, title, content
		mapper.boardUpdate(vo); // 수정
		
		return "redirect:/boardList.do";
	}
}
