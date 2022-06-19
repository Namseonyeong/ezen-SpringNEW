package com.ezen.biz.common;

public class AfterAdvice {
	
	/*
	 * 	try-catch-finally 구문에서 finally 블록처럼 예외 발생 여부에 상관없이,
	 * 	무조건 수행되는 어드바이스를 등록할 때 사용.
	 * 	(비즈니스 메소드가 실행된 후, 무조건 실행)
	 */
	public void finallyLog() {
		System.out.println("[사후 처리]: 비즈니스 로직 수행 !후! !!!무조건!!! 수행...");
	}
}
