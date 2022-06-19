package com.ezen.biz.common;
// pointcut...? 
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

//AOP���� �����Ҷ��� Aspect �ʼ� 
@Aspect
public class PointcutCommon {
	@Pointcut("execution(* com.ezen.biz *Impl.get*(..))")
	public void getPointcut() { }
	@Pointcut("execution(* com.ezen.biz *Impl.(..))")
	public void allPointcut() { }
	
}
