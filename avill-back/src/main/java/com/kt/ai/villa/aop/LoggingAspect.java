package com.kt.ai.villa.aop;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kt.ai.villa.rest.response.SeesawResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.StopWatch;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Slf4j
/*
 * 원래 AOP의 실행 순서는 정의된 것이 없고 랜덤으로 실행되나,
 * Order annotation을 통해 실행 순서를 지정할 수 있음
 *
 * Order annotation은 AOP의 실행 순서 지정을 위해 사용
 * 	- Order가 지정된 경우 지정되지 않은 AOP보다 우선 실행
 *  - Order 값이 낮은 AOP 우선 실행됨
 */
@Aspect
@Order(1)
@Component
public class LoggingAspect {


    private ObjectMapper objectMapper = new ObjectMapper();

    @Around("within(com.kt.ai.villa.controller..*)")
    public Object doLogging(ProceedingJoinPoint pjp) throws Throwable {
        log.debug("Start "+printUseMemory());
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        String uri = request.getRequestURI();
        log.debug("<--  Start Url request: {}", uri);
        log.debug("<--   Parameters: {}", objectMapper.writeValueAsString(request.getParameterMap()));
        log.debug("<--      Headers:");

        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String name = (String) headerNames.nextElement();
            String value = request.getHeader(name);
            log.debug("<--             : {}: {}", name, value);
        }

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object result = pjp.proceed();

        if(result == null)
            return result;

        SeesawResponse<?> seesawResponse = null;

        /*
         * ResponseEntity가 반환된 경우
         */
        if(result instanceof ResponseEntity) {
            ResponseEntity<?> responseEntity = (ResponseEntity<?>) result;

            /*
             * org.springframework.core.io.Resource가 반환된 경우
             * (파일 다운로드)
             */
            if(responseEntity.getBody() instanceof Resource) {
                stopWatch.stop();
                log.debug("--> Url response: {} in {} millis.", uri, stopWatch.getTime());
                log.debug("--> ResponseBody: {}, Content-Type: {}",
                        responseEntity.getHeaders().getContentDisposition().toString(),
                        responseEntity.getHeaders().getContentType());

                return result;
            }

            seesawResponse = (SeesawResponse<?>) responseEntity.getBody();
            stopWatch.stop();
            log.debug("--> Url response: {} ({}) in {} millis.", uri, seesawResponse.getHeader().getResultCode(), stopWatch.getTime());
            log.debug("--> ResponseBody: {}", objectMapper.writeValueAsString(seesawResponse));

            return result;
        }

        /*
         * SeesawResponse가 반환된 경우
         */
        seesawResponse = (SeesawResponse<?>) result;

        stopWatch.stop();
        log.debug("--> Url response: {} ({}) in {} millis.", uri, seesawResponse.getHeader().getResultCode(), stopWatch.getTime());
        log.debug("--> ResponseBody: {}", objectMapper.writeValueAsString(seesawResponse));
        log.debug(printUseMemory());
        return result;
    }

    public static String printUseMemory() {
        //(Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory())+"/"+Runtime.getRuntime().totalMemory() +" "+ ((double)((double)(Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory())/(double)Runtime.getRuntime().totalMemory())*100)
        double free = ((Runtime.getRuntime().freeMemory()/1024.0)/1024.0);
        double total = ((Runtime.getRuntime().totalMemory()/1024.0)/1024.0);
        double used = (total - free);
        double ret = (used/total) * 100;

        String strlog = String.format("UseMemory = %f/%f (%.2f %%)", used, total, ret);
        return strlog;
    }
}
