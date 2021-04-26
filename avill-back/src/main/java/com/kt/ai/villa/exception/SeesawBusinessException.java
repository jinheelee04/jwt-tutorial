package com.kt.ai.villa.exception;

import com.kt.ai.villa.rest.response.SeesawResultCode;
import org.thymeleaf.util.StringUtils;

public class SeesawBusinessException extends RuntimeException {

	private static final long serialVersionUID = 368721185641243544L;
	
	private SeesawResultCode result;
	
	public SeesawBusinessException(SeesawResultCode result) {
		super(result.message());

		this.result = result;
	}

	public SeesawBusinessException(SeesawResultCode result, String message) {
		super(StringUtils.concat(result.message(), " ", message));

		this.result = result;
	}
	
	public SeesawResultCode getResultCode() {
		return this.result;
	}

}
