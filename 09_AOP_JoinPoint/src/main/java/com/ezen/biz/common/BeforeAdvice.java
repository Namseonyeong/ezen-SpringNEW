package com.ezen.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;

public class BeforeAdvice {
	
	/*
	 * 	Before 어드바이스는 비즈니스 메소드가 실행되기 전에 동작할 로직을 구현하므로,
	 * 	JoinPoint 매개변수를 이용하여 다양한 사전 처리 로직 구현.
	 */
	public void beforeLog(JoinPoint jp) {
		// 업무처리 메소드의 선언부 정보를 얻어온다.
		Signature sig = jp.getSignature();
		
		String method = sig.getName();
		Object[] args = jp.getArgs();
		
		System.out.println("\n[사전 처리]: 비즈니스 로직 수행 !전! 처리...");
		if (args.length == 0) {		// 비즈니스 로직 호출시 매개변수가 !없음!
			System.out.printf("메소드명: %s\n", method);
			System.out.printf("매개변수: 없음.\n");
		} else {
			System.out.printf("메소드명: %s\n", method);
			System.out.printf("매개변수: %s\n", args[0].toString());
		}
		
	}
}
