package com.iu.base.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDAO;
	
	public MemberVO getLogin(MemberVO memberVO) throws Exception{
		
		return memberDAO.getLogin(memberVO);
	}
	
	public int setJoin(MemberVO memberVO) throws Exception{
		int result = memberDAO.setJoin(memberVO);
		
		result = memberDAO.setRoleAdd(memberVO);
		return result;
	}
	
	public MemberVO getMyPage(MemberVO memberVO)throws Exception{
		return memberDAO.getLogin(memberVO);
	}
	
}
