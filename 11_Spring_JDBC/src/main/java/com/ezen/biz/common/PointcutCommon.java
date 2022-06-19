package com.ezen.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutCommon {
	@Pointcut("execution(* com.ezen.biz..*Impl.*(..))")
	public void allPointcut() { }  // 메소드 선언 방식으로 이름을 지정
	
	@Pointcut("execution(* com.ezen.biz..*Impl.get(..))")
	public void getPointcut() { }
}
