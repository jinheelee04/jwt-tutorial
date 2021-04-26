package com.kt.ai.villa.exception;


import com.kt.ai.villa.rest.response.SeesawResponse;
import com.kt.ai.villa.rest.response.SeesawResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

/**
 * 
 * 공통 Exception 처리를 위한 전역 컨트롤러 클래스.
 * RestControllerAdvice Annotation을 통해 전역 컨트롤러 설정.
 *
 */
@RestControllerAdvice
@Slf4j
public class SeesawGlobalExceptionHandler {
	
	/**
	 * SeesawBusinessException 처리
	 * 
	 * @param e SeesawBusinessException 객체
	 * @return ResponseEntity<Response> 응답 객체
	 * 
	 */
	@ExceptionHandler(com.kt.ai.villa.exception.SeesawBusinessException.class)
	public ResponseEntity<SeesawResponse<?>> handleSeesawBusinessException (final com.kt.ai.villa.exception.SeesawBusinessException e) {
		log.error("SeesawBusinessException: {}", e.getMessage());
		e.printStackTrace();

		return ResponseEntity.badRequest()
				.body(SeesawResponse.failed(e.getResultCode()));
	}

	/**
	 * Spring Validation Exception 처리
	 * 
	 * @param e ConstraintViolationException 객체
	 * @return ResponseEntity<Response> 응답 객체
	 */
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<SeesawResponse<?>> handleConstraintViolationException (final ConstraintViolationException e) {
		log.error("ConstraintViolationException: {}", e.getMessage());
		e.printStackTrace();
		return ResponseEntity.badRequest()
				.body(SeesawResponse.failed(SeesawResultCode.DATA_VALIDATION_FAILED, e.getMessage()));
	}

	/**
	 * Spring Validation Exception 처리
	 * 
	 * @param e MethodArgumentNotValidException 객체
	 * @return ResponseEntity<Response> 응답 객체
	 * 
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<SeesawResponse<?>> handleMethodArgumentNotValidException (final MethodArgumentNotValidException e) {
		log.error("MethodArgumentNotValidException: {}", e.getMessage());
		e.printStackTrace();

		return ResponseEntity.badRequest()
				.body(SeesawResponse.failed(SeesawResultCode.DATA_VALIDATION_FAILED, e.getMessage()));
	}


	//SQL Exception 처리 필요


}
