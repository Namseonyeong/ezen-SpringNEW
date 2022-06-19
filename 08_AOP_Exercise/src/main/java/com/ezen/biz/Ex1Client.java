package com.ezen.biz;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
 * 	-------  연습용 메인 클라이언트.  -------
 */

public class Ex1Client {

	public static void main(String[] args) {
		AbstractApplicationContext container =
				new GenericXmlApplicationContext("applicationContext.xml");
		
		Operation op = (Operation) container.getBean("opBean");
				
		System.out.println("msg 호출>>>");
			op.message();
			System.out.println("------------------------------.");
			
		System.out.println("m 호출>>>");
			int result = op.m();
			System.out.println("op.m()의 실행 결과는" + result);
			System.out.println("------------------------------.");
			
		System.out.println("k 호출>>>");
			int result2 = op.k();
			System.out.println("op.k()의 실행 결과는" + result2);
			
		container.close();

	}
}


