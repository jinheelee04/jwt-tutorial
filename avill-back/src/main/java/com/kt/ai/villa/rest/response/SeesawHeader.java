package com.kt.ai.villa.rest.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 처리결과 응답 헤더
 */
@Data(staticConstructor="of")
@Accessors(chain=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SeesawHeader {

	private int resultCode;
	private String resultMessage;



	public SeesawHeader setResponseResult(SeesawResultCode result) {
		this.resultCode = result.code();
		this.resultMessage = result.message();

		return this;
	}
	
	public boolean failed() {
		return resultCode != SeesawResultCode.SUCCESS.code() ? false : true;
	}
	
}
