package com.iu.base.member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iu.base.board.notice.NoticeController;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/member/*")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("login")
	public ModelAndView getLogin() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/login");
		
		return mv;
	}
	
	@PostMapping("login")
	public ModelAndView getLogin(MemberVO memberVO, HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		memberVO = memberService.getLogin(memberVO);
		
		mv.setViewName("redirect:./login");
		if(memberVO != null) {
			session.setAttribute("member", memberVO);
			mv.setViewName("redirect:../");
		}
		return mv;
	}
	
	@GetMapping("logout")
	public ModelAndView getLogout(HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		session.invalidate();
		mv.setViewName("redirect:../");
		return mv;
	}
	
	@GetMapping("join")
	public ModelAndView setJoin(ModelAndView mv) {
		mv.setViewName("member/join");
		return mv;
	}
	
	@PostMapping("join")
	public String setJoin(MemberVO memberVO) throws Exception{
		int result = memberService.setJoin(memberVO);
		System.out.println(result == 1);
		return "redirect:../";
	}
	
	@GetMapping("mypage")
	public ModelAndView getMyPage(HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		MemberVO memberVO = (MemberVO) session.getAttribute("member");
		
		memberVO = memberService.getMyPage(memberVO);
		mv.addObject("memberVO", memberVO);
		mv.setViewName("member/mypage");
		return mv;
	}
	
}
