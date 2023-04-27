package com.iu.base.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional(rollbackFor = Exception.class)
public class MemberService implements UserDetailsService {

	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		log.error("============Spring Security Login============");
		log.error("====================={}=====================", username);
		MemberVO memberVO = new MemberVO();
		memberVO.setUsername(username);
		try {
			memberVO = memberDAO.getLogin(memberVO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return memberVO;
	}
	
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
				bindingResult.rejectValue("username", "member.userName.equal");
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
		//memberVO.setEnabled(true);
		memberVO.setPassword(passwordEncoder.encode(memberVO.getPassword()));
		
		int result = memberDAO.setJoin(memberVO);
		
		Map<String, Object> map = new HashMap<>();
		map.put("username", memberVO.getUsername());
		map.put("num", 3);
		result = memberDAO.setRoleAdd(map);
		return result;
	}
	
	public MemberVO getMyPage(MemberVO memberVO)throws Exception{
		return memberDAO.getLogin(memberVO);
	}
	
	public int setLogout(MemberVO memberVO) throws Exception{
		return memberDAO.setLogout(memberVO);
	}
	
}
