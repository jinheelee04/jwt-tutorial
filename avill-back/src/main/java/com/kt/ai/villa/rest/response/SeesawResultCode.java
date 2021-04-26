package com.kt.ai.villa.rest.response;

import java.util.Arrays;

/**
 * @author KwanIk
 */
public enum SeesawResultCode {
	
	/**
	 * 정상 처리
	 * {@code 000: Continue}.
	 */
	SUCCESS(000,  "OK"),

	/*
	 * ============================================================
	 * 공통(Common) 처리 응답 코드
	 * ============================================================
	 */

	/**
	 * {@code 104: 입력 데이터가 유효하지 않습니다}.
	 */
	DATA_VALIDATION_FAILED(104,  "입력 데이터가 유효하지 않습니다.");
	
	private int code;
	private String message;

	SeesawResultCode(int code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public int code() {
		return this.code;
	}
	
	public String message() {
		return this.message;
	}
	
	public static SeesawResultCode codeOf(int code) {
		return Arrays.stream(SeesawResultCode.values())
			.filter(rc -> rc.code() == code)
			.findAny()
			.orElse(null);
	}
}
