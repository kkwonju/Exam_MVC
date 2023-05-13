package com.koreaIT.kkwo.exam.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreaIT.kkwo.exam.demo.service.MemberService;
import com.koreaIT.kkwo.exam.demo.util.Ut;
import com.koreaIT.kkwo.exam.demo.vo.Member;
import com.koreaIT.kkwo.exam.demo.vo.ResultData;
import com.koreaIT.kkwo.exam.demo.vo.Rq;

@Controller
public class UsrMemberController {
	@Autowired
	private MemberService memberService;
	
	public UsrMemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@RequestMapping("/usr/member/join")
	public String join(HttpServletRequest req) {
		Rq rq = new Rq(req);
		if(rq.isLogined()) {
			return rq.jsHistoryBackOnView("로그아웃 후 이용해주세요");
		}
		return "usr/member/join";
	}
	
	@RequestMapping("usr/member/doJoin")
	@ResponseBody
	public String doJoin(HttpServletRequest req, String loginId, String loginPw, String name, String nickName, String cellphoneNum, String email) {
		Rq rq = new Rq(req);
		
		if(rq.isLogined()) {
			return Ut.jsHistoryBack("로그아웃 후 이용해주세요");
		}
		if(Ut.isEmpty(loginId)) {
			return Ut.jsHistoryBack("아이디를 입력하세요");
		}
		if(Ut.isEmpty(loginPw)) {
			return Ut.jsHistoryBack("비밀번호를 입력하세요");
		}
		if(Ut.isEmpty(name)) {
			return Ut.jsHistoryBack("이름을 입력하세요");
		}
		if(Ut.isEmpty(nickName)) {
			return Ut.jsHistoryBack("닉네임을 입력하세요");
		}
		if(Ut.isEmpty(cellphoneNum)) {
			return Ut.jsHistoryBack("전화번호를 입력하세요");
		}
		if(Ut.isEmpty(email)) {
			return Ut.jsHistoryBack("이메일을 입력하세요");
		}

		ResultData joinRd = memberService.doJoin(loginId, loginPw, name, nickName, cellphoneNum, email);
		
		if(joinRd.isFail()) {
			return Ut.jsHistoryBack(joinRd.getResultMsg());
		}
		
		return Ut.jsReplace("회원가입 성공", "../member/login");
	}
	
	@RequestMapping("/usr/member/login")
	public String login(HttpServletRequest req) {
		Rq rq = new Rq(req);
		if(rq.isLogined()) {
			return rq.jsHistoryBackOnView("로그아웃 후 이용해주세요");
		}
		return "usr/member/login";
	}
	
	@RequestMapping("usr/member/doLogin")
	@ResponseBody
	public String doLogin(HttpServletRequest req, String loginId, String loginPw) {
		Rq rq = new Rq(req);
		if(rq.isLogined()) {
			return Ut.jsHistoryBack("로그아웃 후 이용해주세요");
		}
		if(Ut.isEmpty(loginId)) {
			return Ut.jsHistoryBack("아이디를 입력하세요");
		}
		if(Ut.isEmpty(loginPw)) {
			return Ut.jsHistoryBack("비밀번호를 입력하세요");
		}
		
		ResultData loginRd = memberService.doLogin(loginId, loginPw);
		if(loginRd.isFail()) {
			return Ut.jsHistoryBack(loginRd.getResultMsg());
		}
		Member member = memberService.getMemberById((int)loginRd.getData1());
		if(member == null) {
			return Ut.jsHistoryBack("일치하는 회원이 없습니다");
		}
		rq.login(member);
		return Ut.jsReplace(String.format("%s님 반갑습니다", member.getNickName()), "/");
	}

	@RequestMapping("usr/member/doLogout")
	@ResponseBody
	public String doLogout(HttpServletRequest req) {
		Rq rq = new Rq(req);
		if(!rq.isLogined()) {
			return Ut.jsHistoryBack("로그인 후 이용해주세요");
		}
		rq.logout();
		return Ut.jsReplace("로그아웃되었습니다", "../member/login");
	}
}
			