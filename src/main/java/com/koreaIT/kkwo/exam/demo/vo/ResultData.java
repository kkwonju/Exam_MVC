package com.koreaIT.kkwo.exam.demo.vo;

import lombok.Getter;

public class ResultData {
	@Getter
	private String resultCode;
	@Getter
	private String resultMsg;
	@Getter
	private Object data1;

	public static ResultData buildRd(String resultCode, String resultMsg) {
		return buildRd(resultCode, resultMsg, null);
	}
	
	public static ResultData buildRd(String resultCode, String resultMsg, Object data1) {
		ResultData rd = new ResultData();
		rd.resultCode = resultCode;
		rd.resultMsg = resultMsg;
		rd.data1 = data1;
		return rd;
	}
	
	public boolean isSuccess() {
		return resultCode.startsWith("S-");
	}
	
	public boolean isFail() {
		return isSuccess() == false;
	}
}
