package com.ezen.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect
public class AroundAdvice {
	
//	@Pointcut("execution(* com.ezen.biz..*Impl.*(..))")
//	public void allPointcut() { }
	
	/*
	 * 	메소드 호출 자체를 가로채 비즈니스 메소드 실행 전후에 처리할 로직을 삽입할 수 있음.
	 * 	하나의 어드바이스가 비즈니스 메소드 실행 전과 후에 모두 동작하여 로직을 처리할 때 사용.
	 * 
	 * 	리턴값:
	 * 	 Object: 비즈니스 로직 수행한 결과 return 값을 호출한 쪽으로 전달하기 위해 사용.
	 */
	
	@Around("PointcutCommon.allPointcut()")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		// pjp.proceed() 메소드 호출 앞에 작성된 코드는 Before 어드바이스와 동일하게 동작.
		String method = pjp.getSignature().getName(); // 호출할 비즈니스 메소드 이동
		
		
		// 메소드 실행시간 측정을 위한 객체 생성
		StopWatch stopWatch = new StopWatch();
		
		stopWatch.start();  // 비즈니스 메소드 시작 시간 측정
	
		// 비즈니스 로직 호출 후 리턴값 반환.
		Object returnObj = pjp.proceed();
		
		stopWatch.stop();  // 비즈니스 메소드 종료 시간 측정
		
		System.out.printf("메소드명 : %s  수행에 걸린 시간 : %d(ms)\n", method, stopWatch.getTotalTimeMillis());
		
		return returnObj;
	}
}
