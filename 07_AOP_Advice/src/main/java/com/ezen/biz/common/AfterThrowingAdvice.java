package com.ezen.biz.common;

public class AfterThrowingAdvice {
	
	/*
	 * 	포인트컷으로 지정한 메소드가 실행 !!중!! 에 예외가 발생하는 시점에 동작한다.
	 * 	예외 처리 어드바이스를 설정할 때 사용.
	 * 	(try~catch 블록에서 catch 블록과 유사)
	 */
	public void exceptionLog() {
		System.out.println("[예외 처리]: 비즈니스 로직 수행 !중! 예외발생...");
	}
}
