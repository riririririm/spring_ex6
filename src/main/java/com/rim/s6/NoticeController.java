package com.rim.s6;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rim.board.BoardDTO;
import com.rim.board.notice.NoticeDTO;
import com.rim.board.notice.NoticeServiceImpl;
import com.rim.util.PageMaker;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/notice/**")
public class NoticeController {

	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);

	@Inject
	private NoticeServiceImpl noticeService;

	////////////////////////////////////////////////////////////////
	@RequestMapping(value = "noticeSelect", method = RequestMethod.GET)
	public ModelAndView getSelect(@RequestParam(defaultValue = "0", required = false) int num) throws Exception {
		BoardDTO noticeDTO = null;

		noticeDTO = noticeService.getSelect(num);
		ModelAndView mv = new ModelAndView();
		if (noticeDTO != null) {
			mv.addObject("noticeDTO", noticeDTO);
			mv.addObject("board", "notice");
			mv.setViewName("board/boardSelect");
		}

		return mv;
	}

	////////////////////////////////////////////////////////////////////
	@RequestMapping(value = "noticeList", method = RequestMethod.GET)
	public ModelAndView getList(PageMaker pageMaker) throws Exception {
		
		
		return null;
	}

	//////////////////////////////////////////////////////////////////////
	@RequestMapping(value = "noticeWrite", method = RequestMethod.GET)
	public String setWrite(Model model) {
		model.addAttribute("board", "notice");
		return "board/boardWrite";
	}

	@RequestMapping(value = "noticeWrite", method = RequestMethod.POST)
	public String setWrite(NoticeDTO noticeDTO) throws Exception {

		int result = noticeService.setWrite(noticeDTO);

		return "redirect:./noticeList";

	}

	///////////////////////////////////////////////////////////////////////////
	@RequestMapping(value = "noticeDelete", method = RequestMethod.GET)
	public String delete(int num) throws Exception {

		int result = noticeService.setDelete(num);
		if (result > 0)
			System.out.println("삭제성공");

		return "redirect:./noticeList";

	}

///////////////////////////////////////////////////////////////////////////
	@RequestMapping(value = "noticeUpdate", method = RequestMethod.POST)
	public String update(NoticeDTO noticeDTO) throws Exception {

		int result = noticeService.setUpdate(noticeDTO);
		if (result > 0)
			System.out.println("업데이트 성공");

		return "redirect:./noticeList";

	}

}
