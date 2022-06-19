// 0610 의존성을 줄이기 위한 
package com.ezen.biz;

public interface Speaker {

	//인터페이스는 객체화 시킬수 없음. 그래서 스피커를 사용하는 BoseSpeaker에 객체 생성해야됨
	
	public void volumeUp();
	
	public void volumeDown();
	
}
