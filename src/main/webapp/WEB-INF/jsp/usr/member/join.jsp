<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../common/head.jspf" %>
	<div class="container fd-c">
		<h1>회원가입</h1>
		<form action="../member/doJoin">
			<div class="flex fd-c">
				<label for="loginId">아이디</label>
				<input name="loginId" type="text" autocomplete="off" id="loginId"/>
				
				<label for="loginPw">비밀번호</label>
				<input name="loginPw" type="password" autocomplete="off" id="loginPw"/>
				
				<label for="name">이름</label>
				<input name="name" type="text" autocomplete="off" id="name"/>
				
				<label for="nickName">닉네임</label>
				<input name="nickName" type="text" autocomplete="off" id="nickName"/>
				
				<label for="cellphoneNum">전화번호</label>
				<input name="cellphoneNum" type="tel" autocomplete="off" id="cellphoneNum"/>
				
				<label for="email">이메일</label>
				<input name="email" type="email" autocomplete="off" id="email"/>
				<br />
				<button type="submit">가입</button>
				
			</div>
		</form>
		<a href="/">홈으로</a>
	</div>
<%@ include file="../common/foot.jspf" %>