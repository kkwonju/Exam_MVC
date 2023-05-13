package com.koreaIT.kkwo.exam.demo.vo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.springframework.stereotype.Component;

import com.koreaIT.kkwo.exam.demo.service.MemberService;

import lombok.Getter;

public class Rq {
	@Getter
	private boolean isLogined;
	@Getter
	private int loginedMemberId;

	private HttpServletRequest req;
	private HttpSession session;

	public Rq(HttpServletRequest req) {
		this.req = req;
		this.session = req.getSession();
		
		boolean isLogined = false;
		int loginedMemberId = 0;
		
		
		if(session.getAttribute("loginedMemberId") != null) {
			isLogined = true;
			loginedMemberId = (int) session.getAttribute("loginedMemberId");
		}
		
		this.isLogined = isLogined;
		this.loginedMemberId = loginedMemberId;
	}
	
	public void login(Member member) {
		session.setAttribute("loginedMemberId", member.getId());
	}
	
	public void logout() {
		session.removeAttribute("loginedMemberId");
	}
	
	public String jsHistoryBackOnView(String resultMsg) {
		req.setAttribute("resultMsg", resultMsg);
		req.setAttribute("historyBack", true);
		return "usr/common/js";
	}
	
	public String jsReplaceOnView(String resultMsg, String replaceUri) {
		req.setAttribute("resultMsg", resultMsg);
		req.setAttribute("replaceUri", replaceUri);
		return"usr/common/js";
	}
}