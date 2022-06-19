package com.ezen.biz;

import org.springframework.stereotype.Component;

/*
 * 	-------  비즈니스 로직을 포함하는 클래스.  -------
 */

@Component("opBean")
public class Operation {
	public void message() {
		System.out.println("message() method 호출됨.\n");
	}
	
	public int m() {
		System.out.println("m() 메소드 호출됨.\n");
		return 2;
	}
		
	public int k() {
		System.out.println("k() 메소드 호출됨.\n");
		return 3;
	}
		
	public void throwException() {
		throw new RuntimeException("예외 발생...");
	}
	
}