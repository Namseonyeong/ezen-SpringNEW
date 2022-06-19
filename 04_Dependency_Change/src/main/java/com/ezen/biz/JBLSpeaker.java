//0609 처음에 파일 생성할때 중간 네모칸에서 add해서 speaker 인터페이스 추가함
package com.ezen.biz;

public class JBLSpeaker implements Speaker {
	
	public JBLSpeaker() {
		System.out.println("===> JBL Speaker 객체가 생성");
	}

	@Override
	public void volumeUp() {
		
		System.out.println("JBL Speaker -- 소리를 올린다.");
	}

	@Override
	public void volumeDown() {
		
		System.out.println("JBL Speaker -- 소리를 내린다.");
	}

}
