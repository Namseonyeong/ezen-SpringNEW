package com.ezen.biz.common;
// pointcut...? 
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

//AOP관련 설정할때는 Aspect 필수 
@Aspect
public class PointcutCommon {
	@Pointcut("execution(* com.ezen.biz *Impl.get*(..))")
	public void getPointcut() { }
	@Pointcut("execution(* com.ezen.biz *Impl.(..))")
	public void allPointcut() { }
	
}
