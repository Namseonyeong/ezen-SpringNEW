package com.ezen.biz;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/*
 * 	-------  어드바이스를 포함하는 애스팩트 클래스.  -------
 */

public class TrackOperation {

	public void myadvice(JoinPoint jp) {
		System.out.println("부가 기능 수행!");
	}
	
	public void myadvice2(JoinPoint jp) {
		System.out.println("[사후 처리]: 부가 기능 수행!");
	}
	
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
		// pjp.proceed() 메소드 호출 앞에 작성된 코드는 Before 어드바이스와 동일하게 동작.
		System.out.println("[사전 처리]: 비즈니스 메소드 수행 !전! 처리내용...");
	
		// 비즈니스 로직 호출 후 리턴값 반환.
		Object returnObj = pjp.proceed();
		
		// pjp.proceed() 메소드 호출 뒤에 작성한 코드는 After 어드바이스와 동일하게 동작.
		System.out.println("[사후 처리]: 비즈니스 메소드 수행 !후! 처리내용...");
		
		return returnObj;
	}
}
