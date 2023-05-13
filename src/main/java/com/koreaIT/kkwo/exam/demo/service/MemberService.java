package com.koreaIT.kkwo.exam.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreaIT.kkwo.exam.demo.repository.MemberRepository;
import com.koreaIT.kkwo.exam.demo.vo.Member;
import com.koreaIT.kkwo.exam.demo.vo.ResultData;

@Service
public class MemberService {
	@Autowired
	private MemberRepository memberRepository;

	public ResultData doJoin(String loginId, String loginPw, String name, String nickName, String cellphoneNum,
			String email) {
		
		Member member = memberRepository.getMemberByLoginId(loginId);
		if(member != null) {
			return ResultData.buildRd("F-1", "이미 사용 중인 아이디입니다");
		}
		
		member = memberRepository.getMemberByEmail(email);
		if(member != null) {
			return ResultData.buildRd("F-2", "이미 사용 중인 이메일입니다");
		}
		
		memberRepository.doJoin(loginId, loginPw, name, nickName, cellphoneNum, email);
		
		return ResultData.buildRd("S-1", "회원가입 성공");
	}

	public ResultData doLogin(String loginId, String loginPw) {
		Member member = memberRepository.getMemberByLoginId(loginId);
		if(member == null) {
			return ResultData.buildRd("F-3", "일치하는 아이디가 없습니다");
		}
		if(!member.getLoginPw().equals(loginPw)) {
			return ResultData.buildRd("F-4", "비밀번호가 틀립니다");
		}
		return ResultData.buildRd("S-1", "로그인 성공", member.getId());
	}

	public Member getMemberById(int id) {
		return memberRepository.getMemberById(id);
	}

}
