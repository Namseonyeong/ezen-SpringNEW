//0610 Speaker와 연결
package com.ezen.biz;

import org.springframework.stereotype.Component;

// bean객체로 생성하라고 component 를 설정 
@Component("bose")
public class BoseSpeaker implements Speaker {
	
//	기본생성자 : 의존성주입을 하려면 기본생성자 필수임
	public BoseSpeaker() {
		System.out.println("---> Bose Speaker 객체 생성");
	}
	
	
	@Override
	public void volumeUp() {
		System.out.println("Bose Speaker -- 볼륨을 올린다.");
	}

	@Override
	public void volumeDown() {
		System.out.println("Bose Speaker -- 볼륨을 내린다.");
	}

}
