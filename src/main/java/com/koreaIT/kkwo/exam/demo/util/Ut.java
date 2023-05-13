package com.koreaIT.kkwo.exam.demo.util;

public class Ut {
	public static boolean isEmpty(Object obj) {
		if(obj == null) {
			return true;
		}
		
		if(!(obj instanceof String)) {
			return true;
		}
		
		String str = (String) obj;
		
		return str.trim().length() == 0;
	}
	
	public static String jsHistoryBack(String resultMsg) {
		if(resultMsg == null) {
			resultMsg = "";
		}
		return String.format("""
				<script>
					const resultMsg = '%s'.trim();
					if(resultMsg.length > 0){
						alert(resultMsg);
					}
					history.back();
				</script>
				""", resultMsg);
	}
	
	public static String jsReplace(String resultMsg, String replaceUri) {
		if(resultMsg == null) {
			resultMsg = "";
		}
		if(replaceUri == null) {
			replaceUri = "/";
		}
		
		return String.format("""
				<script>
					const resultMsg = '%s'.trim();
					if(resultMsg.length > 0){
						alert(resultMsg);
					}
					location.replace('%s');
				</script>
				""", resultMsg, replaceUri);
	}
	
}
