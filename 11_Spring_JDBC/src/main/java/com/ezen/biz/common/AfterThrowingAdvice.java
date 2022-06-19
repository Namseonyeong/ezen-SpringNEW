package com.ezen.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterThrowingAdvice {
	
	/*
	 * After Throwing은 비즈니스 메소드가 수행 중 예외가 발생했을 떄 동작하는 어드바이스이므로,
	 * 어떤 메소드에서 예외가 발생했는지 알아야한다.
	 * 
	 * JoinPoint - 예외가 발생한 메소드 정보를 알아낸다.
	 * exceptObj - 비즈니스 메소드에서 발생한 예외 객체를 바인드 하는 변수
	 */
	
//	*Impl = 적용할 class 명 , *(..) = 예외발생시 모든 예외
//	@Pointcut("execution(* com.ezen.biz..*Impl.*(..))")
//	public void allPointcut() { }

	@AfterThrowing(pointcut = "PointcutCommon.allPointcut()", throwing = "exceptObj")

	public void exceptionLog(JoinPoint jp, Exception exceptObj) {
		String method = jp.getSignature().getName(); // 호출할 비즈니스 메소드 이름.

//		%s() 메소드명 호출 
	    System.out.printf("[예외 처리]: %s() 수행 !중! 예외발생: %s\n", method, exceptObj.getMessage());
	}
}
