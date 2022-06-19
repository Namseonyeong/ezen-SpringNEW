package com.ezen.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;

public class AroundAdvice {
	
	/*
	 * 	메소드 호출 자체를 가로채 비즈니스 메소드 실행 전후에 처리할 로직을 삽입할 수 있음.
	 * 	하나의 어드바이스가 비즈니스 메소드 실행 전과 후에 모두 동작하여 로직을 처리할 때 사용.
	 * 
	 * 	리턴값:
	 * 	 Object: 비즈니스 로직 수행한 결과 return 값을 호출한 쪽으로 전달하기 위해 사용.
	 */
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		// pjp.proceed() 메소드 호출 앞에 작성된 코드는 Before 어드바이스와 동일하게 동작.
		System.out.println("[BEFORE]: 비즈니스 메소드 수행 !전! 에 처리할 내용...");
	
		// 비즈니스 로직 호출 후 리턴값 반환.
		Object returnObj = pjp.proceed();
		
		// pjp.proceed() 메소드 호출 뒤에 작성한 코드는 After 어드바이스와 동일하게 동작.
		System.out.println("[AFTER]: 비즈니스 메소드 수행 !후! 에 처리할 내용...");
		
		return returnObj;
	}
}
