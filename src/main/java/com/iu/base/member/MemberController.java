package com.iu.base.member;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.iu.base.board.notice.NoticeController;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/member/*")
@Slf4j
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("info")
	public void info(HttpSession session) {
		log.error("=======Login Info=======");
//		Enumeration<String> names = session.getAttributeNames();
//		while(names.hasMoreElements()) {
//			log.error("====={}=====", names.nextElement());
//		}
		Object obj = session.getAttribute("SPRING_SECURITY_CONTEXT");
		SecurityContextImpl contextImpl = (SecurityContextImpl)obj;
		Authentication authentication = contextImpl.getAuthentication();
		
		log.error("====={}=====",obj);
		log.error("=====NAME : {}=====", authentication.getName());
		log.error("=====Detail : {}=====", authentication.getDetails());
		log.error("=====Principal : {}=====", authentication.getPrincipal());
	}
	
	@GetMapping("idDuplicateCheck")
	@ResponseBody
	public boolean idDuplicateCheck(MemberVO memberVO) throws Exception{
		log.debug("==========ID 중복 체크=============");
		
		memberVO = memberService.idDuplicateCheck(memberVO);
		
		boolean check = false;
		
		if(memberVO == null) {
			check = true;
		}
		
		return check;
	}
	
	@GetMapping("login")
	public ModelAndView getLogin(HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		Object obj = session.getAttribute("SPRING_SECURITY_CONTEXT");
		
		if(obj == null){
			mv.setViewName("member/login");
		}
		else {
			mv.setViewName("redirect:/");
		}
		
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
		MemberVO memberVO = (MemberVO) session.getAttribute("member");
		int result = memberService.setLogout(memberVO);
		session.invalidate();
		mv.setViewName("redirect:../");
		return mv;
	}
	
	@GetMapping("join")
	public ModelAndView setJoin(@ModelAttribute MemberVO memberVO) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/join");
		mv.addObject(new MemberVO());
		return mv;
	}
	
	@PostMapping("join")
	public ModelAndView setJoin(@Valid MemberVO memberVO, BindingResult bindingResult) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		boolean check = memberService.passwordCheck(memberVO, bindingResult);
		
		if(check) {
			log.warn("======검증 실패========");
			mv.setViewName("member/join");
			
			return mv;
		}
		
		int result = memberService.setJoin(memberVO);
		System.out.println(result == 1);
		
		mv.setViewName("redirect:../");
		return mv;
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
	
	@GetMapping("admin")
	public ModelAndView getAdmin(HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		MemberVO memberVO = (MemberVO) session.getAttribute("member");
		
		memberVO = memberService.getMyPage(memberVO);
		mv.addObject("memberVO", memberVO);
		mv.setViewName("member/mypage");
		return mv;
	}
	
}
