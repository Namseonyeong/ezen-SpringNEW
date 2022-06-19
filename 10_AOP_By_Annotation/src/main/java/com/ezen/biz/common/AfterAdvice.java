package com.ezen.biz.common;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterAdvice {
//	@Pointcut("execution(* com.ezen.biz..*Impl.*(..))")
//	public void allPointcut() { }
	

	@After("PointcutCommon.allPointcut()")
	public void finallyLog() {
		System.out.println("[사후 처리]: 비즈니스 로직 수행 후 ~무조건~ 수행...");
	}
}




/*
 * 	try-catch-finally 구문에서 finally 블록처럼 예외 발생 여부에 상관없이,
 * 	무조건 수행되는 어드바이스를 등록할 때 사용.
 * 	(비즈니스 메소드가 실행된 후, 무조건 실행)
 */