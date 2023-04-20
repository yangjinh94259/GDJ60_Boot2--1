package com.iu.base.member;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper
public interface MemberDAO {
	
	public MemberVO getLogin(MemberVO memberVO) throws Exception;
	
	public int setJoin(MemberVO memberVO) throws Exception;
	
	public int setRoleAdd(MemberVO memberVO) throws Exception;
}
