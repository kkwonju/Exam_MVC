<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../common/head.jspf" %>
	<div class="container fd-c">
		<h1>로그인</h1>
		<form action="../member/doLogin">
			<div class="flex fd-c">
				<label for="loginId">아이디</label>
				<input name="loginId" type="text" autocomplete="off" id="loginId"/>
				
				<label for="loginPw">비밀번호</label>
				<input name="loginPw" type="password" autocomplete="off" id="loginPw"/>
				<br />
				<button type="submit">로그인</button>
			</div>
		</form>
		<a href="/">홈으로</a>
	</div>
<%@ include file="../common/foot.jspf" %>