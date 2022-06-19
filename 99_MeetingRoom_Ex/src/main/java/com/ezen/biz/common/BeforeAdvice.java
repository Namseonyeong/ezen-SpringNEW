package com.ezen.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class BeforeAdvice {
	
	// 이게 뭐얌...?
	@Before("PointcutCommon.allPointcut()")
	public void deforeLog(JoinPoint jp) {
		String method = jp.getSignature().getName(); //Signature...?
		Object[] args = jp.getArgs();
		
		// args 파라메타가 있을경우 없을경우 구분
		if (args.length != 0) { // 비즈니스 로직 호출시 매개변수가 존재
			System.out.printf("[사전 처리] 메소드명 : %s(), Args : %s\n", method, args[0].toString());
		} else {
			System.out.printf("[사전 처리] 메소드명 : %s(), Args : 없음\n", method);
		}
	}
}
