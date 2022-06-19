package com.ezen.biz.common;

public class AfterReturningAdvice {
	
	/*
	 * 	포인트컷으로 지정된 메소드가 정상적으로 실행되고 나서,
	 * 	메소드 수행 결과로 생성된 데이터를 리턴하는 시점에 동작한다.
	 * 	
	 * 	비즈니스 메소드 수행 결과로 얻은 결과 데이터를 이용하여
	 * 	사후 처리 로직을 추가할 때 사용.
	 * 
	 * 	(비즈니스 메소드가 성공적으로 리턴되면 동작.)
	 */
	public void afterLog() {
		System.out.println("[사후 처리]: 비즈니스 로직 수행 !후! 작업...");
	}
}
