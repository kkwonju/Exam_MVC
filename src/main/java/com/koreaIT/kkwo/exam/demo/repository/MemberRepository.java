package com.koreaIT.kkwo.exam.demo.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.koreaIT.kkwo.exam.demo.vo.Member;

@Mapper
public interface MemberRepository {

	@Select("""
			SELECT *
			FROM `member`
			WHERE loginId = #{loginId}
			""")
	public Member getMemberByLoginId(String loginId);

	@Select("""
			SELECT *
			FROM `member`
			WHERE email = #{email}
			""")
	public Member getMemberByEmail(String email);	

	@Insert("""
			INSERT INTO `member`
			SET loginId = #{loginId},
			loginPw = #{loginPw},
			`name` = #{name},
			nickName = #{nickName},
			cellphoneNum = #{cellphoneNum},
			email = #{email}
			""")
	public void doJoin(String loginId, String loginPw, String name, String nickName, String cellphoneNum,
			String email);

	@Select("""
			SELECT *
			FROM `member`
			WHERE id = #{id}
			""")
	public Member getMemberById(int id);
}
