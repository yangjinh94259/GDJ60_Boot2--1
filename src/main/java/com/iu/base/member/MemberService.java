package com.iu.base.member;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import lombok.extern.slf4j.Slf4j;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDAO;
	
	//패스워드가 일치하는지 검증
	public boolean passwordCheck(MemberVO memberVO, BindingResult bindingResult) throws Exception{
		boolean result = false;
		//false : error가 없음, 검증성공
		//true면 : error가 실패, 검증실패
		
		result = bindingResult.hasErrors();
		
		//1. annotation 검증결과
		
		//2. password 일치검증
		if(!memberVO.getPassword().equals(memberVO.getPasswordCheck())) {
			result = true;
			bindingResult.rejectValue("passwordCheck", "member.password.notEqual");
		}
		
		MemberVO check = memberDAO.idDuplicateCheck(memberVO);
		
		//3. ID중복 검사
		if(check != null) {
				result = true;
				bindingResult.rejectValue("userName", "member.userName.equal");
		}
		
		return result;
		
	}
	
	public MemberVO idDuplicateCheck(MemberVO memberVO) throws Exception{
		return memberDAO.idDuplicateCheck(memberVO);
	}
	
	public MemberVO getLogin(MemberVO memberVO) throws Exception{
		
		return memberDAO.getLogin(memberVO);
	}
	
	public int setJoin(MemberVO memberVO) throws Exception{
		memberVO.setEnabled(true);
		int result = memberDAO.setJoin(memberVO);
		
		Map<String, Object> map = new HashMap<>();
		map.put("userName", memberVO.getUserName());
		map.put("num", 3);
		result = memberDAO.setRoleAdd(map);
		return result;
	}
	
	public MemberVO getMyPage(MemberVO memberVO)throws Exception{
		return memberDAO.getLogin(memberVO);
	}
	
}
