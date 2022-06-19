package com.ezen.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;


@Service
@Aspect
public class AfterReturningAdvice {

//	@Pointcut("execution(* com.ezen.biz..*Impl.get*(..))")
//	public void getPointcut() { }	
	
	/*
	 * After Returning 은 비즈니스 메소드가 수행되고 나서, 결과 데이터를 리턴할 때 동작하는 어드바이스 이므로 JoinPoint
	 * 매개변수를 이용하여 !!사후!! 처리 기능을 다양하게 구현 가능.
	 */
	
	
	// 리턴오브젝트로 지정을 해야돼서 앞에 pointcut이라는 값을 줌
	@AfterReturning(pointcut = "PointcutCommon.getPointcut()", returning = "returnObj")  
	public void afterLog(JoinPoint jp, Object returnObj) {
		String method = jp.getSignature().getName(); // 호출할 비즈니스 메소드 이름.

		System.out.println("[사후 처리]: 비즈니스 로직 수행 후 작업...");
		System.out.printf("[사후 처리]: %s(), 리턴값: %s\n", method, returnObj.toString());

		

	}
}




/*
 * 포인트컷으로 지정된 메소드가 정상적으로 실행되고 나서, 메소드 수행 결과로 생성된 데이터를 리턴하는 시점에 동작한다.
 * 
 * 비즈니스 메소드 수행 결과로 얻은 결과 데이터를 이용하여 사후 처리 로직을 추가할 때 사용.
 * 
 * (비즈니스 메소드가 성공적으로 리턴되면 동작.)
 * 
 * 	public void afterLog(JoinPoint jp, Object returnObj) {
	String method = jp.getSignature().getName();
 * 
 * 
 * public void afterLog() { System.out.println("[사후 처리]: 비즈니스 로직 수행 !후! 작업...");
 */