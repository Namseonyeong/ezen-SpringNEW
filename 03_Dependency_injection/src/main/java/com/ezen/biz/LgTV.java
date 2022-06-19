//0608 결합도가 높은 프로그램 실습 (다형성)
package com.ezen.biz;

public class LgTV implements TV {
	
	
	public LgTV() {
		System.out.println("LgTV 객체를 생성합니다");	
	}
	
	
	
	public void initMethod() {
		System.out.println("객체 초기화 작업 처리..........");
	}
	
	public void destroyMethod() {
		System.out.println("객체 삭제 전 처리할 로직...............");
	}
	
	@Override
	public void powerOn() {
		System.out.println("LgTV -- 전원을 켠다.");
	
	}
	
	@Override
	public void powerOff() {
		System.out.println("LgTV -- 전원을 끈다.");
	}
	
	@Override
	public void volumeUp() {
		System.out.println("LgTV -- 소리를 올린다.");
	}
	
	@Override
	public void volumeDown() {
		System.out.println("LgTV -- 소리를 내린다.");
	}
}

