package com.kt.ai.villa.rest.response;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)
public class SeesawResponse<T> {
	private SeesawHeader header;

	private T body;
	
	public static <T extends Object> SeesawResponse<T> build(SeesawResultCode result, T body) {
		return new SeesawResponse<T>()
				.setHeader(SeesawHeader.of()
						.setResponseResult(result))
				.setBody(body);
	}

	public static <T> SeesawResponse<T> ok(T body) {
		return new SeesawResponse<T>()
				.setHeader(SeesawHeader.of()
						.setResponseResult(SeesawResultCode.SUCCESS))
				.setBody(body);
	}
	
	public static <T> SeesawResponse<T> ok() {
		return new SeesawResponse<T>()
				.setHeader(SeesawHeader.of()
						.setResponseResult(SeesawResultCode.SUCCESS));
	}
	
	public static <T> SeesawResponse<T> failed(SeesawResultCode result) {
		return SeesawResponse.build(SeesawHeader.of()
				.setResultCode(result.code())
				.setResultMessage(result.message()));
	}

	public static <T> SeesawResponse<T> failed(SeesawResultCode result, String message) {
		return SeesawResponse.build(SeesawHeader.of()
				.setResultCode(result.code())
				.setResultMessage(message));
	}

	/*
	public static <T> Response<T> failed(ResponseResult result, Exception e) {
		return new Response<T>()
				.setHeader(ResponseHeader.of()
						.setResultCode(result.code())
						.setResultMessage(e.getMessage()));
	}
	*/
	
	public static <T> SeesawResponse<T> build(SeesawHeader header) {
		return new SeesawResponse<T>()
				.setHeader(header);
	}
	
	public static <T> SeesawResponse<T> of(SeesawHeader header, T body) {
		return new SeesawResponse<T>()
				.setHeader(header)
				.setBody(body);
	}

}
